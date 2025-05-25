package com.ljw.controller;


import java.util.List;

import com.ljw.annotation.Log;
import com.ljw.entity.dao.DiagnosisReportQuery;
import com.ljw.entity.po.DiagnosisReport;
import com.ljw.enums.BusinessType;
import com.ljw.service.DoctorService;
import com.ljw.entity.vo.ResponseVO;
import com.ljw.entity.po.Doctor;
import com.ljw.entity.dao.DoctorQuery;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @Description:  Controller
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
@RestController
@RequestMapping("/doctors")
public class DoctorController extends ABaseController {

	@Resource
	private DoctorService doctorService;

	@RequestMapping
	@Log(title = "医生", businessType = BusinessType.SELECT)
	public ResponseVO loadDataList(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@RequestParam(value = "name", required = false) String nameFuzzy,
			@RequestParam(value = "department", required = false) String department,
			@RequestParam(value = "license", required = false) String license,
			@RequestParam(value = "verified", required = false) Integer verified
	) {
		DoctorQuery query = new DoctorQuery();
		query.setPageNo(pageNo);
		query.setPageSize(pageSize);
		query.setNameFuzzy(nameFuzzy);
		query.setDepartmentFuzzy(department);
		query.setLicenseFuzzy(license);
		query.setVerified(verified);
		return getSuccessResponseVO(doctorService.findListByPage(query));
	}


	@GetMapping("/lookup")
	@Log(title = "医生", businessType = BusinessType.SELECT)
	public ResponseVO lookup(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "license", required = false) String license
	) {
		DoctorQuery query = new DoctorQuery();
		query.setPageNo(pageNo);
		query.setPageSize(pageSize);
		query.setPhoneFuzzy(phone);
		query.setLicenseFuzzy(license);
		return getSuccessResponseVO(doctorService.findListByPage(query));
	}


	/**
	 * 新增
	 */
	@PostMapping
	@Log(title = "医生", businessType = BusinessType.INSERT)
	public ResponseVO add(@RequestBody Doctor bean) {
		Integer result = this.doctorService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("/addBatch")
	@Log(title = "医生", businessType = BusinessType.INSERT)
	public ResponseVO addBatch(@RequestBody List<Doctor> listBean) {
		this.doctorService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Doctor> listBean) {
		this.doctorService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据 Id 查询
	 */
	@RequestMapping("/{id}")
	@Log(title = "医生", businessType = BusinessType.SELECT)
	public ResponseVO getDockerById(@PathVariable("id") Integer id) {
		return getSuccessResponseVO(doctorService.getDoctorById(id));
	}

	/**
	 * 根据 Id 更新
	 */
	@PutMapping("/{id}")
	@Log(title = "医生", businessType = BusinessType.UPDATE)
	public ResponseVO updateDockerById(@RequestBody Doctor doctor, @PathVariable Integer id) {
		this.doctorService.updateDockerById(doctor, id);
		return getSuccessResponseVO(doctorService.getDoctorById(id));
	}

	/**
	 * 根据 Id 删除
	 */
	@DeleteMapping("/{id}")
	@Log(title = "医生", businessType = BusinessType.DELETE)
	public ResponseVO deleteDockerById(@PathVariable Integer id) {
		this.doctorService.deleteDockerById(id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 获取医生的诊断报告
	 */
	@GetMapping("/{id}/diagnoses")
	@Log(title = "医生", businessType = BusinessType.SELECT)
	public ResponseVO getDockerDiagnosesById(@PathVariable Integer id,
											 @RequestBody DiagnosisReportQuery query) {

		{
			query.setDoctorId(id);
			List<DiagnosisReport> diagnosisReportList = this.doctorService.getDockerDiagnosesById(query);
			return getSuccessResponseVO(diagnosisReportList);
		}
	}
}