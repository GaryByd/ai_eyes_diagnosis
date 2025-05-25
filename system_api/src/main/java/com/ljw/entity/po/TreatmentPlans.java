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
public class TreatmentPlans implements Serializable {
	/**
 	 * 主键ID
 	 */
	private Integer id;

	/**
 	 * 关联DiagnosisReport表
 	 */
	private Integer diagnosisId;

	/**
 	 * 治疗类型（药物、手术、激光治疗等）
 	 */
	private String treatmentType;

	/**
 	 * 治疗方案详细信息
 	 */
	private String treatmentDetail;

	/**
 	 * 治疗开始时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;

	/**
 	 * 治疗结束时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endDate;

	/**
 	 * 关联Docker表
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

	public void setTreatmentType(String treatmentType) {
		this.treatmentType = treatmentType;
	}

	public String getTreatmentType() {
		return treatmentType;
	}

	public void setTreatmentDetail(String treatmentDetail) {
		this.treatmentDetail = treatmentDetail;
	}

	public String getTreatmentDetail() {
		return treatmentDetail;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate() {
		return endDate;
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
				"关联DiagnosisReport表:" + (diagnosisId == null ? "空" : diagnosisId) + "," + 
				"治疗类型（药物、手术、激光治疗等）:" + (treatmentType == null ? "空" : treatmentType) + "," + 
				"治疗方案详细信息:" + (treatmentDetail == null ? "空" : treatmentDetail) + "," + 
				"治疗开始时间:" + (startTime == null ? "空" : DateUtils.format(startTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"治疗结束时间:" + (endDate == null ? "空" : DateUtils.format(endDate, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"关联Docker表:" + (doctorId == null ? "空" : doctorId) + "," + 
				"创建时间:" + (createdTime == null ? "空" : DateUtils.format(createdTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"更新时间:" + (updatedTime == null ? "空" : DateUtils.format(updatedTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
		}
}