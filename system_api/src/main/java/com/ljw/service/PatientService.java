package com.ljw.service;


import com.ljw.entity.dao.PatientQuery;
import com.ljw.entity.po.DiagnosisReport;
import com.ljw.entity.po.Patient;
import com.ljw.entity.vo.PaginationResultVO;

import java.util.List;

/**
 * @Description:  Service
 * @Author: false
 * @Date: 2025/03/19 15:56:11
 */
public interface PatientService {

	/**
 	 * 根据条件查询列表
 	 */
	List<Patient> findListByParam(PatientQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(PatientQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<Patient> findListByPage(PatientQuery query);

	/**
 	 * 新增
 	 */
	Integer add(Patient bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<Patient> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<Patient> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	Patient getPatientById(Integer id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updatePatientById(Patient bean, Integer id);

	/**
 	 * 根据 Id 删除
 	 */
	Integer deletePatientById(Integer id);

	Integer getDiagnosisCount(Integer id);

	DiagnosisReport getRecentDiagnosis(Integer id);

	Integer recentMonthPatientsCount();
}