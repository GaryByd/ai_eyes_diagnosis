package com.ljw.service.impl;


import java.util.List;
import com.ljw.entity.dao.SimplePage;
import com.ljw.entity.dto.TokenUserInfoDTO;
import com.ljw.enums.PageSize;
import com.ljw.exception.BusinessException;
import com.ljw.mapper.TreatmentPlansMapper;
import com.ljw.redis.RedisComponent;
import com.ljw.service.TreatmentPlansService;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.entity.po.TreatmentPlans;
import com.ljw.entity.dao.TreatmentPlansQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description:  业务接口实现
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
@Service("TreatmentPlansMapper")
public class TreatmentPlansServiceImpl implements TreatmentPlansService{

	@Resource
	private TreatmentPlansMapper<TreatmentPlans, TreatmentPlansQuery> treatmentPlansMapper;
	
	@Resource
	private RedisComponent redisComponent;
	
	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<TreatmentPlans> findListByParam(TreatmentPlansQuery query) {
		return this.treatmentPlansMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(TreatmentPlansQuery query) {
		return this.treatmentPlansMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<TreatmentPlans> findListByPage(TreatmentPlansQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<TreatmentPlans> list = this.findListByParam(query);
		PaginationResultVO<TreatmentPlans> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(TreatmentPlans bean) {
		// 获取现在的时间
		bean.setCreatedTime(new java.util.Date());
		bean.setUpdatedTime(new java.util.Date());
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if(attributes == null){
			throw new BusinessException("无法获取请求信息");
		}
		HttpServletRequest request = attributes.getRequest();
		String token = request.getHeader("token");
		// 获取现在用户的医生id
		TokenUserInfoDTO tokenUserInfo = redisComponent.getTokenUserInfoDTO(token);
		if (tokenUserInfo == null) {
			throw new BusinessException("用户未登录或登录已过期");
		}
		
		// 设置医生ID
		bean.setDoctorId(tokenUserInfo.getId());

		return this.treatmentPlansMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<TreatmentPlans> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.treatmentPlansMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<TreatmentPlans> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.treatmentPlansMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public TreatmentPlans getTreatmentPlansById(Integer id) {
		return this.treatmentPlansMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updateTreatmentPlansById(TreatmentPlans bean, Integer id) {
		return this.treatmentPlansMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deleteTreatmentPlansById(Integer id) {
		return this.treatmentPlansMapper.deleteById(id);}
}
