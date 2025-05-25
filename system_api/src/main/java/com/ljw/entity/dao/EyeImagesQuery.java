package com.ljw.entity.dao;



/**
 * @Description: 
 * @Author: false
 * @Date: 2025/03/18 21:41:43
 */
public class EyeImagesQuery extends BaseQuery {
	/**
 	 * 主键ID 查询对象
 	 */
	private Integer id;

	/**
 	 * 图片路径 查询对象
 	 */
	private String url;

	private String urlFuzzy;

	/**
 	 * 关联报告ID 查询对象
 	 */
	private Integer dignosisReportId;

	/**
 	 * 眼别 OD/OS 查询对象
 	 */
	private String eyePosition;

	private String eyePositionFuzzy;

	/**
 	 * DICOM元数据 查询对象
 	 */
	private String dicomData;

	private String dicomDataFuzzy;


	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setDignosisReportId(Integer dignosisReportId) {
		this.dignosisReportId = dignosisReportId;
	}

	public Integer getDignosisReportId() {
		return dignosisReportId;
	}

	public void setEyePosition(String eyePosition) {
		this.eyePosition = eyePosition;
	}

	public String getEyePosition() {
		return eyePosition;
	}

	public void setDicomData(String dicomData) {
		this.dicomData = dicomData;
	}

	public String getDicomData() {
		return dicomData;
	}

	public void setUrlFuzzy(String urlFuzzy) {
		this.urlFuzzy = urlFuzzy;
	}

	public String getUrlFuzzy() {
		return urlFuzzy;
	}

	public void setEyePositionFuzzy(String eyePositionFuzzy) {
		this.eyePositionFuzzy = eyePositionFuzzy;
	}

	public String getEyePositionFuzzy() {
		return eyePositionFuzzy;
	}

	public void setDicomDataFuzzy(String dicomDataFuzzy) {
		this.dicomDataFuzzy = dicomDataFuzzy;
	}

	public String getDicomDataFuzzy() {
		return dicomDataFuzzy;
	}
}