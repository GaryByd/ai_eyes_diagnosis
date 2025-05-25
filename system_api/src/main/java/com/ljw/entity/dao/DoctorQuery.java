package com.ljw.entity.dao;

import java.util.Date;


/**
 * @Description: 
 * @Author: false
 * @Date: 2025/03/18 21:41:43
 */
public class DoctorQuery extends BaseQuery {
	/**
 	 * 主键ID 查询对象
 	 */
	private Integer id;
	/**
 	 * 电话号码 查询对象
 	 */
	private String phone;

	private String phoneFuzzy;

	/**
 	 * 身份证号 查询对象
 	 */
	private String idCard;

	private String idCardFuzzy;

	/**
 	 * 姓名 查询对象
 	 */
	private String name;

	private String nameFuzzy;

	/**
 	 * 是否实名认证(0:否,1:是) 查询对象
 	 */
	private Integer verified;

	/**
 	 * 审核人 查询对象
 	 */
	private String verifiedBy;

	private String verifiedByFuzzy;

	/**
 	 * 审核时间 查询对象
 	 */
	private Date verifiedTime;

	private String verifiedTimeStart;
	private String verifiedTimeEnd;
	/**
 	 * 执业编号 查询对象
 	 */
	private String license;

	private String licenseFuzzy;

	/**
 	 * 科室 查询对象
 	 */
	private String department;

	private String departmentFuzzy;

	/**
 	 * 医院医生编号 查询对象
 	 */
	private String hospitalPid;

	private String hospitalPidFuzzy;


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

	public void setPhoneFuzzy(String phoneFuzzy) {
		this.phoneFuzzy = phoneFuzzy;
	}

	public String getPhoneFuzzy() {
		return phoneFuzzy;
	}

	public void setIdCardFuzzy(String idCardFuzzy) {
		this.idCardFuzzy = idCardFuzzy;
	}

	public String getIdCardFuzzy() {
		return idCardFuzzy;
	}

	public void setNameFuzzy(String nameFuzzy) {
		this.nameFuzzy = nameFuzzy;
	}

	public String getNameFuzzy() {
		return nameFuzzy;
	}

	public void setVerifiedByFuzzy(String verifiedByFuzzy) {
		this.verifiedByFuzzy = verifiedByFuzzy;
	}

	public String getVerifiedByFuzzy() {
		return verifiedByFuzzy;
	}

	public void setVerifiedTimeStart(String verifiedTimeStart) {
		this.verifiedTimeStart = verifiedTimeStart;
	}

	public String getVerifiedTimeStart() {
		return verifiedTimeStart;
	}

	public void setVerifiedTimeEnd(String verifiedTimeEnd) {
		this.verifiedTimeEnd = verifiedTimeEnd;
	}

	public String getVerifiedTimeEnd() {
		return verifiedTimeEnd;
	}

	public void setLicenseFuzzy(String licenseFuzzy) {
		this.licenseFuzzy = licenseFuzzy;
	}

	public String getLicenseFuzzy() {
		return licenseFuzzy;
	}

	public void setDepartmentFuzzy(String departmentFuzzy) {
		this.departmentFuzzy = departmentFuzzy;
	}

	public String getDepartmentFuzzy() {
		return departmentFuzzy;
	}

	public void setHospitalPidFuzzy(String hospitalPidFuzzy) {
		this.hospitalPidFuzzy = hospitalPidFuzzy;
	}

	public String getHospitalPidFuzzy() {
		return hospitalPidFuzzy;
	}
}