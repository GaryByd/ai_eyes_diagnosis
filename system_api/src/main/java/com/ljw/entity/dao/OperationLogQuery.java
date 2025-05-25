package com.ljw.entity.dao;

import java.util.Date;


/**
 * @Description: 
 * @Author: false
 * @Date: 2025/03/24 18:16:01
 */
public class OperationLogQuery extends BaseQuery {
	/**
 	 * 主键ID 查询对象
 	 */
	private Integer id;

	/**
 	 * 操作用户ID 查询对象
 	 */
	private Integer userId;

	/**
 	 * 操作用户角色（admin管理员 doctor医生 patient病人 查询对象
 	 */
	private String role;

	private String roleFuzzy;

	/**
 	 * 业务模块标题 查询对象
 	 */
	private String title;

	private String titleFuzzy;

	/**
 	 * 业务类型 SELECT UPDATE
 	 */
	private String businessType;

	private String businessTypeFuzzy;

	/**
 	 * 请求方法 查询对象
 	 */
	private String method;

	private String methodFuzzy;

	/**
 	 * 请求路径 查询对象
 	 */
	private String requestUrl;

	private String requestUrlFuzzy;

	/**
 	 * 请求者ip 查询对象
 	 */
	private String operIp;

	private String operIpFuzzy;

	/**
 	 * 操作状态（0正常 1异常） 查询对象
 	 */
	private Integer status;

	/**
 	 * 错误信息 查询对象
 	 */
	private String errorMsg;

	private String errorMsgFuzzy;

	/**
 	 * 操作时间 查询对象
 	 */
	private Date createTime;

	private String createTimeStart;
	private String createTimeEnd;
	/**
 	 * 操作耗时
 	 */
	private Long costTime;


	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getMethod() {
		return method;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setOperIp(String operIp) {
		this.operIp = operIp;
	}

	public String getOperIp() {
		return operIp;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCostTime(Long costTime) {
		this.costTime = costTime;
	}

	public Long getCostTime() {
		return costTime;
	}

	public void setRoleFuzzy(String roleFuzzy) {
		this.roleFuzzy = roleFuzzy;
	}

	public String getRoleFuzzy() {
		return roleFuzzy;
	}

	public void setTitleFuzzy(String titleFuzzy) {
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy() {
		return titleFuzzy;
	}

	public void setBusinessTypeFuzzy(String businessTypeFuzzy) {
		this.businessTypeFuzzy = businessTypeFuzzy;
	}

	public String getBusinessTypeFuzzy() {
		return businessTypeFuzzy;
	}

	public void setMethodFuzzy(String methodFuzzy) {
		this.methodFuzzy = methodFuzzy;
	}

	public String getMethodFuzzy() {
		return methodFuzzy;
	}

	public void setRequestUrlFuzzy(String requestUrlFuzzy) {
		this.requestUrlFuzzy = requestUrlFuzzy;
	}

	public String getRequestUrlFuzzy() {
		return requestUrlFuzzy;
	}

	public void setOperIpFuzzy(String operIpFuzzy) {
		this.operIpFuzzy = operIpFuzzy;
	}

	public String getOperIpFuzzy() {
		return operIpFuzzy;
	}

	public void setErrorMsgFuzzy(String errorMsgFuzzy) {
		this.errorMsgFuzzy = errorMsgFuzzy;
	}

	public String getErrorMsgFuzzy() {
		return errorMsgFuzzy;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateTimeEnd() {
		return createTimeEnd;
	}
}