package com.ljw.service;


import java.util.List;

import com.ljw.entity.dao.DiagnosisReportQuery;
import com.ljw.entity.dto.TokenUserInfoDTO;
import com.ljw.entity.po.DiagnosisReport;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.entity.po.Doctor;
import com.ljw.entity.dao.DoctorQuery;
/**
 * @Description:  Service
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
public interface DoctorService {

	/**
 	 * 根据条件查询列表
 	 */
	List<Doctor> findListByParam(DoctorQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(DoctorQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<Doctor> findListByPage(DoctorQuery query);

	/**
 	 * 新增
 	 */
	Integer add(Doctor bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<Doctor> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<Doctor> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	Doctor getDoctorById(Integer id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateDockerById(Doctor bean, Integer id);

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteDockerById(Integer id);

	TokenUserInfoDTO login(String phone, String code);

	void getCode(String phone);

	List<DiagnosisReport> getDockerDiagnosesById(DiagnosisReportQuery query);
}