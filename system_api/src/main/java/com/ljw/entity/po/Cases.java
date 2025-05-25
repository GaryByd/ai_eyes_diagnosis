package com.ljw.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ljw.enums.DateTimePatternEnum;
import com.ljw.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * @Description: 
 * @Author: false
 * @Date: 2025/03/18 21:41:43
 */
public class Cases implements Serializable {
	/**
 	 * 主键ID
 	 */
	private Integer id;
	/**
 	 * 关联多个dignosisReport（;分隔）
 	 */
	private String dignosisReports;

	/**
 	 * 治疗方案id
 	 */
	private Integer treatmentPlanId;

	/**
 	 * 关联医院患者表
 	 */
	private Integer patientId;

	/**
 	 * 症状描述（JSON格式，如视力模糊、眼痛等）
 	 */
	private String symptoms;

	/**
 	 * 诊断方法（如眼底检查、眼压测量等）
 	 */
	private String diagnosisMethod;

	/**
 	 * 恢复时长（单位：天）
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date recoveryTime;

	/**
 	 * 记录创建时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	/**
 	 * 病人名称
 	 */
	private String patientName;

	/**
 	 * 病人身份证号
 	 */
	private String idCard;

	/**
 	 * 状态: confirmed/archived
 	 */
	private String status;


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
	@Override
	public String toString() {
		return "主键ID:" + (id == null ? "空" : id) + "," + 
				"关联多个dignosisReport（;分隔）:" + (dignosisReports == null ? "空" : dignosisReports) + "," + 
				"治疗方案id:" + (treatmentPlanId == null ? "空" : treatmentPlanId) + "," + 
				"关联医院患者表:" + (patientId == null ? "空" : patientId) + "," + 
				"症状描述（JSON格式，如视力模糊、眼痛等）:" + (symptoms == null ? "空" : symptoms) + "," + 
				"诊断方法（如眼底检查、眼压测量等）:" + (diagnosisMethod == null ? "空" : diagnosisMethod) + "," + 
				"恢复时长（单位：天）:" + (recoveryTime == null ? "空" : DateUtils.format(recoveryTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"记录创建时间:" + (createdTime == null ? "空" : DateUtils.format(createdTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"病人名称:" + (patientName == null ? "空" : patientName) + "," + 
				"病人身份证号:" + (idCard == null ? "空" : idCard) + "," + 
				"状态: confirmed/archived:" + (status == null ? "空" : status);
		}
}