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
public class DataAnalysis implements Serializable {
	/**
 	 * 主键ID
 	 */
	private Integer id;

	/**
 	 * 统计数据
 	 */
	private String statistics;

	/**
 	 * 生成时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date generateTime;


	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setStatistics(String statistics) {
		this.statistics = statistics;
	}

	public String getStatistics() {
		return statistics;
	}

	public void setGenerateTime(Date generateTime) {
		this.generateTime = generateTime;
	}

	public Date getGenerateTime() {
		return generateTime;
	}
	@Override
	public String toString() {
		return "主键ID:" + (id == null ? "空" : id) + "," + 
				"统计数据:" + (statistics == null ? "空" : statistics) + "," + 
				"生成时间:" + (generateTime == null ? "空" : DateUtils.format(generateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
		}
}