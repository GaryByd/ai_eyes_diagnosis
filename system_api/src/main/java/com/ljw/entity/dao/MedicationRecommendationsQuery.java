package com.ljw.entity.dao;

import java.util.Date;


/**
 * @Description: 
 * @Author: false
 * @Date: 2025/03/18 21:41:43
 */
public class MedicationRecommendationsQuery extends BaseQuery {
	/**
 	 * 主键ID 查询对象
 	 */
	private Integer id;

	/**
 	 * 关联diagnoses表 查询对象
 	 */
	private Integer diagnosisId;

	/**
 	 * 药物名称 查询对象
 	 */
	private String medicationName;

	private String medicationNameFuzzy;

	/**
 	 * 药物剂量 查询对象
 	 */
	private String dosage;

	private String dosageFuzzy;

	/**
 	 * 用药频率 查询对象
 	 */
	private String frequency;

	private String frequencyFuzzy;

	/**
 	 * 药物副作用 查询对象
 	 */
	private String sideEffects;

	private String sideEffectsFuzzy;

	/**
 	 * 开始用药时间
 查询对象
 	 */
	private Date startTime;

	private String startTimeStart;
	private String startTimeEnd;
	/**
 	 * 停止用药时间
 查询对象
 	 */
	private Date endTime;

	private String endTimeStart;
	private String endTimeEnd;
	/**
 	 * 关联docker表，指向医生 查询对象
 	 */
	private Integer doctorId;

	/**
 	 * 创建时间 查询对象
 	 */
	private Date createdTime;

	private String createdTimeStart;
	private String createdTimeEnd;
	/**
 	 * 更新时间 查询对象
 	 */
	private Date updatedTime;

	private String updatedTimeStart;
	private String updatedTimeEnd;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setDiagnosisId(Integer diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public Integer getDiagnosisId() {
		return diagnosisId;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	public String getMedicationName() {
		return medicationName;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getDosage() {
		return dosage;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setSideEffects(String sideEffects) {
		this.sideEffects = sideEffects;
	}

	public String getSideEffects() {
		return sideEffects;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setMedicationNameFuzzy(String medicationNameFuzzy) {
		this.medicationNameFuzzy = medicationNameFuzzy;
	}

	public String getMedicationNameFuzzy() {
		return medicationNameFuzzy;
	}

	public void setDosageFuzzy(String dosageFuzzy) {
		this.dosageFuzzy = dosageFuzzy;
	}

	public String getDosageFuzzy() {
		return dosageFuzzy;
	}

	public void setFrequencyFuzzy(String frequencyFuzzy) {
		this.frequencyFuzzy = frequencyFuzzy;
	}

	public String getFrequencyFuzzy() {
		return frequencyFuzzy;
	}

	public void setSideEffectsFuzzy(String sideEffectsFuzzy) {
		this.sideEffectsFuzzy = sideEffectsFuzzy;
	}

	public String getSideEffectsFuzzy() {
		return sideEffectsFuzzy;
	}

	public void setStartTimeStart(String startTimeStart) {
		this.startTimeStart = startTimeStart;
	}

	public String getStartTimeStart() {
		return startTimeStart;
	}

	public void setStartTimeEnd(String startTimeEnd) {
		this.startTimeEnd = startTimeEnd;
	}

	public String getStartTimeEnd() {
		return startTimeEnd;
	}

	public void setEndTimeStart(String endTimeStart) {
		this.endTimeStart = endTimeStart;
	}

	public String getEndTimeStart() {
		return endTimeStart;
	}

	public void setEndTimeEnd(String endTimeEnd) {
		this.endTimeEnd = endTimeEnd;
	}

	public String getEndTimeEnd() {
		return endTimeEnd;
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

	public void setUpdatedTimeStart(String updatedTimeStart) {
		this.updatedTimeStart = updatedTimeStart;
	}

	public String getUpdatedTimeStart() {
		return updatedTimeStart;
	}

	public void setUpdatedTimeEnd(String updatedTimeEnd) {
		this.updatedTimeEnd = updatedTimeEnd;
	}

	public String getUpdatedTimeEnd() {
		return updatedTimeEnd;
	}
}