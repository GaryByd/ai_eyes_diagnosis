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
public class Doctor implements Serializable {
	/**
 	 * 主键ID
 	 */
	private Integer id;

	/**
 	 * 电话号码
 	 */
	private String phone;

	/**
 	 * 身份证号
 	 */
	private String idCard;

	/**
 	 * 姓名
 	 */
	private String name;

	/**
 	 * 是否实名认证(0:否,1:是)
 	 */
	private Integer verified;

	/**
 	 * 审核人
 	 */
	private String verifiedBy;

	/**
 	 * 审核时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date verifiedTime;

	/**
 	 * 执业编号
 	 */
	private String license;

	/**
 	 * 科室
 	 */
	private String department;

	/**
 	 * 医院医生编号
 	 */

	private String expertise;
	private String hospitalPid;


	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
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

	public void setVerified(Integer verified) {
		this.verified = verified;
	}

	public Integer getVerified() {
		return verified;
	}

	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

	public String getVerifiedBy() {
		return verifiedBy;
	}

	public void setVerifiedTime(Date verifiedTime) {
		this.verifiedTime = verifiedTime;
	}

	public Date getVerifiedTime() {
		return verifiedTime;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLicense() {
		return license;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setHospitalPid(String hospitalPid) {
		this.hospitalPid = hospitalPid;
	}

	public String getHospitalPid() {
		return hospitalPid;
	}
	@Override
	public String toString() {
		return "主键ID:" + (id == null ? "空" : id) + "," + 
				"电话号码:" + (phone == null ? "空" : phone) + "," + 
				"身份证号:" + (idCard == null ? "空" : idCard) + "," + 
				"姓名:" + (name == null ? "空" : name) + "," + 
				"是否实名认证(0:否,1:是):" + (verified == null ? "空" : verified) + "," + 
				"审核人:" + (verifiedBy == null ? "空" : verifiedBy) + "," + 
				"审核时间:" + (verifiedTime == null ? "空" : DateUtils.format(verifiedTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"执业编号:" + (license == null ? "空" : license) + "," + 
				"科室:" + (department == null ? "空" : department) + "," + 
				"医院医生编号:" + (hospitalPid == null ? "空" : hospitalPid);
		}
}