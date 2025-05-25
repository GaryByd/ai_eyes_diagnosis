package com.ljw.service;


import java.util.List;

import com.ljw.entity.vo.*;
import com.ljw.entity.po.DiagnosisReport;
import com.ljw.entity.dao.DiagnosisReportQuery;

/**
 * @Description:  Service
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
public interface DiagnosisReportService{

	/**
 	 * 根据条件查询列表
 	 */
	List<DiagnosisReport> findListByParam(DiagnosisReportQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(DiagnosisReportQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<DiagnosisReport> findListByPage(DiagnosisReportQuery query);

	/**
 	 * 新增
 	 */
	Integer add(DiagnosisReport bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<DiagnosisReport> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<DiagnosisReport> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	AllVO getAllById(Integer id);
	DiagnosisReport getDiagnosisReportById(Integer id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateDiagnosisReportById(DiagnosisReport bean, Integer id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteDiagnosisReportById(Integer id);

	List<DiseaseCountVO> findDiseaseCount(String startDate, String endDate, String diseaseCategory, String status);

	List<StatusCountVO> findStatusCount(String startDate, String endDate, String diseaseCategory, String status);

	List<DateCountVO> findDateCount(String startDate, String endDate, String diseaseCategory, String status);

    void updateDiagnosisReportWithRelations(AllVO allVO, Integer id);

	void scoreById(Integer id, Integer score);

	List<ModelPerformanceVO> modelPerformance();

	List<DoctorDiagnosisCountVO> getDoctorConfirmedCount();
}