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
 * @Date: 2025/03/19 19:43:23
 */
public class Patient implements Serializable {
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
 	 * openid
 	 */
	private String openId;

	/**
 	 * 医院患者编号
 	 */
	private String hospitalPid;

	/**
 	 * 省
 	 */
	private String province;

	/**
 	 * 市
 	 */
	private String city;

	/**
 	 * 区
 	 */
	private String county;

	/**
 	 * 生日
 	 */
	private String birthday;

	/**
 	 * 性别
 	 */
	private String sex;

	/**
 	 * 年龄
 	 */
	private Integer age;

	/**
 	 * 头像
 	 */
	private String avatar;


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

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
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

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setHospitalPid(String hospitalPid) {
		this.hospitalPid = hospitalPid;
	}

	public String getHospitalPid() {
		return hospitalPid;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvince() {
		return province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCounty() {
		return county;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAvatar() {
		return avatar;
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
				"openid:" + (openId == null ? "空" : openId) + "," + 
				"医院患者编号:" + (hospitalPid == null ? "空" : hospitalPid) + "," + 
				"省:" + (province == null ? "空" : province) + "," + 
				"市:" + (city == null ? "空" : city) + "," + 
				"区:" + (county == null ? "空" : county) + "," + 
				"生日:" + (birthday == null ? "空" : birthday) + "," + 
				"性别:" + (sex == null ? "空" : sex) + "," + 
				"年龄:" + (age == null ? "空" : age) + "," + 
				"头像:" + (avatar == null ? "空" : avatar);
		}
}