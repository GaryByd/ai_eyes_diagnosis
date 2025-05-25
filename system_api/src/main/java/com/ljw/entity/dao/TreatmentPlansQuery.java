package com.ljw.entity.dao;

import java.util.Date;


/**
 * @Description: 
 * @Author: false
 * @Date: 2025/03/18 21:41:43
 */
public class TreatmentPlansQuery extends BaseQuery {
	/**
 	 * 主键ID 查询对象
 	 */
	private Integer id;

	/**
 	 * 关联DiagnosisReport表 查询对象
 	 */
	private Integer diagnosisId;

	/**
 	 * 治疗类型（药物、手术、激光治疗等） 查询对象
 	 */
	private Integer treatmentType;

	/**
 	 * 治疗方案详细信息 查询对象
 	 */
	private String treatmentDetail;

	private String treatmentDetailFuzzy;

	/**
 	 * 治疗开始时间 查询对象
 	 */
	private Date startTime;

	private String startTimeStart;
	private String startTimeEnd;
	/**
 	 * 治疗结束时间 查询对象
 	 */
	private Date endDate;

	private String endDateStart;
	private String endDateEnd;
	/**
 	 * 关联Docker表 查询对象
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

	public void setTreatmentType(Integer treatmentType) {
		this.treatmentType = treatmentType;
	}

	public Integer getTreatmentType() {
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

	public void setTreatmentDetailFuzzy(String treatmentDetailFuzzy) {
		this.treatmentDetailFuzzy = treatmentDetailFuzzy;
	}

	public String getTreatmentDetailFuzzy() {
		return treatmentDetailFuzzy;
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

	public void setEndDateStart(String endDateStart) {
		this.endDateStart = endDateStart;
	}

	public String getEndDateStart() {
		return endDateStart;
	}

	public void setEndDateEnd(String endDateEnd) {
		this.endDateEnd = endDateEnd;
	}

	public String getEndDateEnd() {
		return endDateEnd;
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