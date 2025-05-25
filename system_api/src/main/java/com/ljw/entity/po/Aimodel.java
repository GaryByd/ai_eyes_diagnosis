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
public class Aimodel implements Serializable {
	/**
 	 * 主键
 	 */
	private Integer id;

	/**
 	 * 模型版本
 	 */
	private String version;

	/**
 	 * 部署时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date deployTime;

	/**
 	 * 准确率
 	 */
	private String accuracy;


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
	@Override
	public String toString() {
		return "主键:" + (id == null ? "空" : id) + "," + 
				"模型版本:" + (version == null ? "空" : version) + "," + 
				"部署时间:" + (deployTime == null ? "空" : DateUtils.format(deployTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"准确率:" + (accuracy == null ? "空" : accuracy);
		}
}