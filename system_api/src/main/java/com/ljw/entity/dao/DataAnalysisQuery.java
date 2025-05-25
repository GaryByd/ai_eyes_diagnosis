package com.ljw.entity.dao;

import java.util.Date;


/**
 * @Description: 
 * @Author: false
 * @Date: 2025/03/18 21:41:43
 */
public class DataAnalysisQuery extends BaseQuery {
	/**
 	 * 主键ID 查询对象
 	 */
	private Integer id;

	/**
 	 * 统计数据 查询对象
 	 */
	private String statistics;

	private String statisticsFuzzy;

	/**
 	 * 生成时间 查询对象
 	 */
	private Date generateTime;

	private String generateTimeStart;
	private String generateTimeEnd;

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

	public void setStatisticsFuzzy(String statisticsFuzzy) {
		this.statisticsFuzzy = statisticsFuzzy;
	}

	public String getStatisticsFuzzy() {
		return statisticsFuzzy;
	}

	public void setGenerateTimeStart(String generateTimeStart) {
		this.generateTimeStart = generateTimeStart;
	}

	public String getGenerateTimeStart() {
		return generateTimeStart;
	}

	public void setGenerateTimeEnd(String generateTimeEnd) {
		this.generateTimeEnd = generateTimeEnd;
	}

	public String getGenerateTimeEnd() {
		return generateTimeEnd;
	}
}