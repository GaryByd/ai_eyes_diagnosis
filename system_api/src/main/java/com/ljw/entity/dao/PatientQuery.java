package com.ljw.entity.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @Description: 
 * @Author: false
 * @Date: 2025/03/19 19:43:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientQuery extends BaseQuery {
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
 	 * openid 查询对象
 	 */
	private String openId;

	private String openIdFuzzy;

	/**
 	 * 医院患者编号 查询对象
 	 */
	private String hospitalPid;

	private String hospitalPidFuzzy;

	/**
 	 * 省 查询对象
 	 */
	private String province;

	private String provinceFuzzy;

	/**
 	 * 市 查询对象
 	 */
	private String city;

	private String cityFuzzy;

	/**
 	 * 区 查询对象
 	 */
	private String county;

	private String countyFuzzy;

	/**
 	 * 生日 查询对象
 	 */
	private String birthday;

	private String birthdayFuzzy;

	/**
 	 * 性别 查询对象
 	 */
	private String sex;

	private String sexFuzzy;

	/**
 	 * 年龄 查询对象
 	 */
	private Integer age;
	/**
	 * 起始年龄 查询对象
	 */
	private Integer startAge;
	/**
	 * 结束年龄 查询对象
	 */
	private Integer endAge;

	/**
 	 * 头像 查询对象
 	 */
	private String avatar;

	private String avatarFuzzy;

}