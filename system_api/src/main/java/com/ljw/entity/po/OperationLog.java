package com.ljw.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * @Description: 
 * @Author: false
 * @Date: 2025/03/24 18:16:01
 */
@Data
@ToString
public class OperationLog implements Serializable {
	/**
 	 * 主键ID
 	 */
	private Integer id;

	/**
 	 * 操作用户ID
 	 */
	private Integer userId;

	/**
 	 * 操作用户角色（admin管理员 doctor医生 patient病人
 	 */
	private String role;

	/**
 	 * 业务模块标题
 	 */
	private String title;

	/**
 	 * 业务类型
 	 */
	private String businessType;

	/**
 	 * 请求方法
 	 */
	private String method;

	/**
 	 * 请求路径
 	 */
	private String requestUrl;

	/**
 	 * 请求者ip
 	 */
	private String operIp;

	/**
 	 * 操作状态（0正常 1异常）
 	 */
	@JsonIgnore
	private Integer status;

	/**
 	 * 错误信息
 	 */
	private String errorMsg;

	/**
 	 * 操作时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
 	 * 消耗时间
 	 */
	private Long costTime;
}