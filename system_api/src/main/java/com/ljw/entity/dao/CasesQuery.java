package com.ljw.entity.dao;

import java.util.Date;


/**
 * @Description: 
 * @Author: false
 * @Date: 2025/03/18 21:41:43
 */
public class CasesQuery extends BaseQuery {
	/**
 	 * 主键ID 查询对象
 	 */
	private Integer id;

	/**
 	 * 关联多个dignosisReport（;分隔） 查询对象
 	 */
	private String dignosisReports;

	private String dignosisReportsFuzzy;

	/**
 	 * 治疗方案id 查询对象
 	 */
	private Integer treatmentPlanId;

	/**
 	 * 关联医院患者表 查询对象
 	 */
	private Integer patientId;

	/**
 	 * 症状描述（JSON格式，如视力模糊、眼痛等） 查询对象
 	 */
	private String symptoms;

	private String symptomsFuzzy;

	/**
 	 * 诊断方法（如眼底检查、眼压测量等） 查询对象
 	 */
	private String diagnosisMethod;

	private String diagnosisMethodFuzzy;

	/**
 	 * 恢复时长（单位：天） 查询对象
 	 */
	private Date recoveryTime;

	private String recoveryTimeStart;
	private String recoveryTimeEnd;
	/**
 	 * 记录创建时间 查询对象
 	 */
	private Date createdTime;

	private String createdTimeStart;
	private String createdTimeEnd;
	/**
 	 * 病人名称 查询对象
 	 */
	private String patientName;

	private String patientNameFuzzy;

	/**
 	 * 病人身份证号 查询对象
 	 */
	private String idCard;

	private String idCardFuzzy;

	/**
 	 * 状态: confirmed/archived 查询对象
 	 */
	private String status;

	private String statusFuzzy;


	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setDignosisReports(String dignosisReports) {
		this.dignosisReports = dignosisReports;
	}

	public String getDignosisReports() {
		return dignosisReports;
	}

	public void setTreatmentPlanId(Integer treatmentPlanId) {
		this.treatmentPlanId = treatmentPlanId;
	}

	public Integer getTreatmentPlanId() {
		return treatmentPlanId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setDiagnosisMethod(String diagnosisMethod) {
		this.diagnosisMethod = diagnosisMethod;
	}

	public String getDiagnosisMethod() {
		return diagnosisMethod;
	}

	public void setRecoveryTime(Date recoveryTime) {
		this.recoveryTime = recoveryTime;
	}

	public Date getRecoveryTime() {
		return recoveryTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setDignosisReportsFuzzy(String dignosisReportsFuzzy) {
		this.dignosisReportsFuzzy = dignosisReportsFuzzy;
	}

	public String getDignosisReportsFuzzy() {
		return dignosisReportsFuzzy;
	}

	public void setSymptomsFuzzy(String symptomsFuzzy) {
		this.symptomsFuzzy = symptomsFuzzy;
	}

	public String getSymptomsFuzzy() {
		return symptomsFuzzy;
	}

	public void setDiagnosisMethodFuzzy(String diagnosisMethodFuzzy) {
		this.diagnosisMethodFuzzy = diagnosisMethodFuzzy;
	}

	public String getDiagnosisMethodFuzzy() {
		return diagnosisMethodFuzzy;
	}

	public void setRecoveryTimeStart(String recoveryTimeStart) {
		this.recoveryTimeStart = recoveryTimeStart;
	}

	public String getRecoveryTimeStart() {
		return recoveryTimeStart;
	}

	public void setRecoveryTimeEnd(String recoveryTimeEnd) {
		this.recoveryTimeEnd = recoveryTimeEnd;
	}

	public String getRecoveryTimeEnd() {
		return recoveryTimeEnd;
	}

	public void setCreatedTimeStart(String createdTimeStart) {
		this.createdTimeStart = createdTimeStart;
	}

	public String getCreatedTimeStart() {
		return createdTimeStart;
	}

	public void setCreatedTimeEnd(String createdTimeEnd) {
		this.createdTimeEnd = createdTimeEnd;
	}

	public String getCreatedTimeEnd() {
		return createdTimeEnd;
	}

	public void setPatientNameFuzzy(String patientNameFuzzy) {
		this.patientNameFuzzy = patientNameFuzzy;
	}

	public String getPatientNameFuzzy() {
		return patientNameFuzzy;
	}

	public void setIdCardFuzzy(String idCardFuzzy) {
		this.idCardFuzzy = idCardFuzzy;
	}

	public String getIdCardFuzzy() {
		return idCardFuzzy;
	}

	public void setStatusFuzzy(String statusFuzzy) {
		this.statusFuzzy = statusFuzzy;
	}

	public String getStatusFuzzy() {
		return statusFuzzy;
	}
}