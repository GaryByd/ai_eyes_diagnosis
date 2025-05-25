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
public class DiagnosisReport implements Serializable {
	/**
 	 * 主键ID
 	 */
	private Integer id;

	/**
 	 * 患者ID
 	 */
	private Integer patientId;

	/**
 	 * 医生ID
 	 */
	private Integer doctorId;

	/**
 	 * 眼疾名称
 	 */
	private String diseaseName;

	/**
 	 * 眼疾分类
 	 */
	private String diseaseCategory;

	/**
 	 * AI模型版本ID
 	 */
	private Integer aimodelId;

	/**
 	 * AI诊断结果
 	 */
	private String result;

	/**
 	 * 创建时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
 	 * confirmed/archived
 	 */
	private String status;

	/**
 	 * 病人身份证号
 	 */
	private String idCard;

	/**
 	 * 病人名称
 	 */
	private String name;

	/**
 	 * 医生打分
 	 */
	private Integer score;

	/**
 	 * 医生备注
 	 */
	private String remark;


	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseCategory(String diseaseCategory) {
		this.diseaseCategory = diseaseCategory;
	}

	public String getDiseaseCategory() {
		return diseaseCategory;
	}

	public void setAimodelId(Integer aimodelId) {
		this.aimodelId = aimodelId;
	}

	public Integer getAimodelId() {
		return aimodelId;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getScore() {
		return score;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}
	@Override
	public String toString() {
		return "主键ID:" + (id == null ? "空" : id) + "," + 
				"患者ID:" + (patientId == null ? "空" : patientId) + "," + 
				"医生ID:" + (doctorId == null ? "空" : doctorId) + "," + 
				"眼疾名称:" + (diseaseName == null ? "空" : diseaseName) + "," + 
				"眼疾分类:" + (diseaseCategory == null ? "空" : diseaseCategory) + "," + 
				"AI模型版本ID:" + (aimodelId == null ? "空" : aimodelId) + "," + 
				"AI诊断结果:" + (result == null ? "空" : result) + "," + 
				"创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"confirmed/archived:" + (status == null ? "空" : status) + "," + 
				"病人身份证号:" + (idCard == null ? "空" : idCard) + "," + 
				"病人名称:" + (name == null ? "空" : name) + "," + 
				"医生打分:" + (score == null ? "空" : score) + "," + 
				"医生备注:" + (remark == null ? "空" : remark);
		}
}