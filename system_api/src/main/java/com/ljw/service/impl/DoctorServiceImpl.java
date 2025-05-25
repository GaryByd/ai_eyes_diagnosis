package com.ljw.service.impl;


import java.util.List;

import com.ljw.constants.Constants;
import com.ljw.entity.dao.DiagnosisReportQuery;
import com.ljw.entity.dao.SimplePage;
import com.ljw.entity.dto.TokenUserInfoDTO;
import com.ljw.entity.po.DiagnosisReport;
import com.ljw.enums.PageSize;
import com.ljw.exception.BusinessException;
import com.ljw.mapper.DoctorMapper;
import com.ljw.redis.RedisUtils;
import com.ljw.service.DiagnosisReportService;
import com.ljw.service.DoctorService;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.entity.po.Doctor;
import com.ljw.entity.dao.DoctorQuery;
import com.ljw.utils.SendSmsUtils;
import com.ljw.utils.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * @Description:  业务接口实现
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
@Service("DockerMapper")
public class DoctorServiceImpl implements DoctorService {

	@Resource
	private DoctorMapper<Doctor, DoctorQuery> doctorMapper;

	@Resource
	private DiagnosisReportService diagnosisReportService;

	@Resource
	private SendSmsUtils sendSmsUtils;

	@Resource
	private RedisUtils redisUtils;
	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<Doctor> findListByParam(DoctorQuery query) {
		return this.doctorMapper.selectList(query);
	}


	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(DoctorQuery query) {
		return this.doctorMapper.selectCount(query);	}

	/**
 	 * 分页查询     c
 	 */
	@Override
	public PaginationResultVO<Doctor> findListByPage(DoctorQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<Doctor> list = this.findListByParam(query);
		PaginationResultVO<Doctor> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(Doctor bean) {
		return this.doctorMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<Doctor> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.doctorMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<Doctor> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.doctorMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public Doctor getDoctorById(Integer id) {
		return this.doctorMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updateDockerById(Doctor bean, Integer id) {
		return this.doctorMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deleteDockerById(Integer id) {
		return this.doctorMapper.deleteById(id);}

	@Override
	public TokenUserInfoDTO login(String phone, String code) {

		Doctor doctor = doctorMapper.selectByPhone(phone);
//		String codeChecked = (String) redisUtils.get(Constants.PHONE_VERIFY_CODE + phone);

		if (doctor == null) {
			throw new BusinessException("该手机号未注册");
		}
//		if(codeChecked == null || codeChecked.equals("")){
//			throw new BusinessException("验证码失效，请重新申请");
//		}
//		if (!code.equals(codeChecked)){
//			throw new BusinessException("验证码错误");
//		}
		if(!code.equals("202504")){
			throw new BusinessException("验证码错误");
		}
		TokenUserInfoDTO tokenUserInfoDTO = new TokenUserInfoDTO();
		String token = StringUtils.encodeByMd5(phone + StringUtils.getRandomString(Constants.LENGTH_21));
		tokenUserInfoDTO.setToken(token);
		tokenUserInfoDTO.setId(doctor.getId());
		tokenUserInfoDTO.setRole("doctor");
		return tokenUserInfoDTO;
	}

	@Override
	public void getCode(String phone) {
		Doctor doctor = doctorMapper.selectByPhone(phone);
		if(doctor == null){
			throw new BusinessException("该手机号未注册");
		}
		Boolean sendSms = sendSmsUtils.sendSms(phone);
		if (!sendSms){
			throw new BusinessException("发送短信失败，请联系工作人员");
		}
	}

	@Override
	public List<DiagnosisReport> getDockerDiagnosesById(DiagnosisReportQuery query) {
		List<DiagnosisReport> listByParam = diagnosisReportService.findListByParam(query);
		return listByParam;
	}
}