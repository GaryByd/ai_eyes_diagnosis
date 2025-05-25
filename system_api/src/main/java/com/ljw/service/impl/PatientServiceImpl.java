package com.ljw.service.impl;


import com.ljw.entity.dao.DiagnosisReportQuery;
import com.ljw.entity.dao.PatientQuery;
import com.ljw.entity.dao.SimplePage;
import com.ljw.entity.po.DiagnosisReport;
import com.ljw.entity.po.Patient;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.enums.PageSize;
import com.ljw.mapper.DiagnosisReportMapper;
import com.ljw.mapper.PatientMapper;
import com.ljw.service.PatientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:  业务接口实现
 * @Author: false
 * @Date: 2025/03/19 15:56:11
 */
@Service("PatientMapper")
public class PatientServiceImpl implements PatientService {

	@Resource
	private PatientMapper<Patient, PatientQuery> patientMapper;

	@Resource
	private DiagnosisReportMapper<DiagnosisReport, DiagnosisReportQuery> diagnosisReportMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<Patient> findListByParam(PatientQuery query) {
		return this.patientMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(PatientQuery query) {
		return this.patientMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<Patient> findListByPage(PatientQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<Patient> list = this.findListByParam(query);
		PaginationResultVO<Patient> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(Patient bean) {
		return this.patientMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<Patient> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.patientMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<Patient> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.patientMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public Patient getPatientById(Integer id) {
		return this.patientMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updatePatientById(Patient bean, Integer id) {
		return this.patientMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deletePatientById(Integer id) {
		return this.patientMapper.deleteById(id);}

	public Integer getDiagnosisCount(Integer id) {
		DiagnosisReportQuery diagnosisReportQuery = new DiagnosisReportQuery();
		diagnosisReportQuery.setPatientId(id);
		return this.diagnosisReportMapper.selectCount(diagnosisReportQuery);
	}

	public DiagnosisReport getRecentDiagnosis(Integer id) {
		return this.diagnosisReportMapper.selectRecentDiagnosis(id);
	}

	@Override
	public Integer recentMonthPatientsCount() {
		return this.diagnosisReportMapper.recentMonthPatientsCount();
	}
}