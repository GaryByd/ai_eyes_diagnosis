package com.ljw.controller;


import com.ljw.entity.dao.PatientQuery;
import com.ljw.entity.po.DiagnosisReport;
import com.ljw.entity.po.Patient;
import com.ljw.entity.vo.ResponseVO;
import com.ljw.service.PatientService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:  Controller
 * @Author: false
 * @Date: 2025/03/19 15:56:11
 */
@RestController
@RequestMapping("/patient")
public class PatientController extends ABaseController{

	@Resource
	private PatientService patientService;

	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(PatientQuery query) {
		return getSuccessResponseVO(patientService.findListByPage(query));
	}

	/**
 	 * 新增
 	 */
	@PostMapping("/add")
	public ResponseVO add(@RequestBody Patient bean) {
		this.patientService.add(bean);
		return getSuccessResponseVO(bean.getId());
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<Patient> listBean) {
		this.patientService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Patient> listBean) {
		this.patientService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@RequestMapping("/getPatientById")
	public ResponseVO getPatientById(Integer id) {
		return getSuccessResponseVO(patientService.getPatientById(id));}

	/**
 	 * 根据 Id 更新
 	 */
	@PutMapping("/updatePatientById")
	public ResponseVO updatePatientById(@RequestBody Patient bean,@RequestParam Integer id) {
		this.patientService.updatePatientById(bean, id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据 Id 删除
	 */
	@RequestMapping("/deletePatientById")
	public ResponseVO deletePatientById(Integer id) {
		this.patientService.deletePatientById(id);
		return getSuccessResponseVO(null);

	}

	/**
	 * 查询当前患者的诊断次数
	 */
	@RequestMapping("/getDiagnosisCount/{id}")
	public ResponseVO getDiagnosisCount(@PathVariable Integer id) {
		Integer count = this.patientService.getDiagnosisCount(id);
		return getSuccessResponseVO(count);
	}

	/**
	 * 查询患者最近一次诊断记录
	 */
	@RequestMapping("/getRecentDiagnosis/{id}")
	public ResponseVO getRecentDiagnosis(@PathVariable Integer id) {
		DiagnosisReport diagnosisReport = this.patientService.getRecentDiagnosis(id);
		return getSuccessResponseVO(diagnosisReport);
	}
}