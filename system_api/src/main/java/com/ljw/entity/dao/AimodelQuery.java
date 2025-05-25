package com.ljw.entity.dao;

import java.util.Date;


/**
 * @Description: 
 * @Author: false
 * @Date: 2025/03/18 21:41:43
 */
public class AimodelQuery extends BaseQuery {
	/**
 	 * 主键 查询对象
 	 */
	private Integer id;

	/**
 	 * 模型版本 查询对象
 	 */
	private String version;

	private String versionFuzzy;

	/**
 	 * 部署时间 查询对象
 	 */
	private Date deployTime;

	private String deployTimeStart;
	private String deployTimeEnd;
	/**
 	 * 准确率 查询对象
 	 */
	private String accuracy;

	private String accuracyFuzzy;


	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public void setDeployTime(Date deployTime) {
		this.deployTime = deployTime;
	}

	public Date getDeployTime() {
		return deployTime;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setVersionFuzzy(String versionFuzzy) {
		this.versionFuzzy = versionFuzzy;
	}

	public String getVersionFuzzy() {
		return versionFuzzy;
	}

	public void setDeployTimeStart(String deployTimeStart) {
		this.deployTimeStart = deployTimeStart;
	}

	public String getDeployTimeStart() {
		return deployTimeStart;
	}

	public void setDeployTimeEnd(String deployTimeEnd) {
		this.deployTimeEnd = deployTimeEnd;
	}

	public String getDeployTimeEnd() {
		return deployTimeEnd;
	}

	public void setAccuracyFuzzy(String accuracyFuzzy) {
		this.accuracyFuzzy = accuracyFuzzy;
	}

	public String getAccuracyFuzzy() {
		return accuracyFuzzy;
	}
}