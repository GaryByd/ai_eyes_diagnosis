package com.ljw.entity.po;

import java.io.Serializable;


/**
 * @Description: 
 * @Author: false
 * @Date: 2025/03/18 21:41:43
 */
public class EyeImages implements Serializable {
	/**
 	 * 主键ID
 	 */
	private Integer id;

	/**
 	 * 图片路径
 	 */
	private String url;

	/**
 	 * 关联报告ID
 	 */
	private Integer dignosisReportId;

	/**
 	 * 眼别 OD/OS
 	 */
	private String eyePosition;

	/**
 	 * DICOM元数据
 	 */
	private String dicomData;


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
	@Override
	public String toString() {
		return "主键ID:" + (id == null ? "空" : id) + "," + 
				"图片路径:" + (url == null ? "空" : url) + "," + 
				"关联报告ID:" + (dignosisReportId == null ? "空" : dignosisReportId) + "," + 
				"眼别 OD/OS:" + (eyePosition == null ? "空" : eyePosition) + "," + 
				"DICOM元数据:" + (dicomData == null ? "空" : dicomData);
		}
}