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
public class MedicationRecommendations implements Serializable {
	/**
 	 * 主键ID
 	 */
	private Integer id;

	/**
 	 * 关联diagnoses表
 	 */
	private Integer diagnosisId;

	/**
 	 * 药物名称
 	 */
	private String medicationName;

	/**
 	 * 药物剂量
 	 */
	private String dosage;

	/**
 	 * 用药频率
 	 */
	private String frequency;

	/**
 	 * 药物副作用
 	 */
	private String sideEffects;

	/**
 	 * 开始用药时间

 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;

	/**
 	 * 停止用药时间

 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;

	/**
 	 * 关联docker表，指向医生
 	 */
	private Integer doctorId;

	/**
 	 * 创建时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	/**
 	 * 更新时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedTime;


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
	@Override
	public String toString() {
		return "主键ID:" + (id == null ? "空" : id) + "," + 
				"关联diagnoses表:" + (diagnosisId == null ? "空" : diagnosisId) + "," + 
				"药物名称:" + (medicationName == null ? "空" : medicationName) + "," + 
				"药物剂量:" + (dosage == null ? "空" : dosage) + "," + 
				"用药频率:" + (frequency == null ? "空" : frequency) + "," + 
				"药物副作用:" + (sideEffects == null ? "空" : sideEffects) + "," + 
				"开始用药时间:" + (startTime == null ? "空" : DateUtils.format(startTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," +
				"停止用药时间:" + (endTime == null ? "空" : DateUtils.format(endTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," +
				"关联docker表，指向医生:" + (doctorId == null ? "空" : doctorId) + "," + 
				"创建时间:" + (createdTime == null ? "空" : DateUtils.format(createdTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"更新时间:" + (updatedTime == null ? "空" : DateUtils.format(updatedTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
		}
}