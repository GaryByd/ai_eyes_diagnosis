package com.ljw.controller;


import java.util.List;
import com.ljw.service.DataAnalysisService;
import com.ljw.entity.vo.ResponseVO;
import com.ljw.entity.po.DataAnalysis;
import com.ljw.entity.dao.DataAnalysisQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
/**
 * @Description:  Controller
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
@RestController
@RequestMapping("/dataAnalysis")
public class DataAnalysisController extends ABaseController{

	@Resource
	private DataAnalysisService dataAnalysisService;

	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(DataAnalysisQuery query) {
		return getSuccessResponseVO(dataAnalysisService.findListByPage(query));
	}

	/**
 	 * 新增
 	 */
	@RequestMapping("/add")
	public ResponseVO add(DataAnalysis bean) {
		Integer result = this.dataAnalysisService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<DataAnalysis> listBean) {
		this.dataAnalysisService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<DataAnalysis> listBean) {
		this.dataAnalysisService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@RequestMapping("/getDataAnalysisById")
	public ResponseVO getDataAnalysisById(Integer id) {
		return getSuccessResponseVO(dataAnalysisService.getDataAnalysisById(id));}

	/**
 	 * 根据 Id 更新
 	 */
	@RequestMapping("/updateDataAnalysisById")
	public ResponseVO updateDataAnalysisById(DataAnalysis bean, Integer id) {
		this.dataAnalysisService.updateDataAnalysisById(bean, id);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 Id 删除
 	 */
	@RequestMapping("/deleteDataAnalysisById")
	public ResponseVO deleteDataAnalysisById(Integer id) {
		this.dataAnalysisService.deleteDataAnalysisById(id);
		return getSuccessResponseVO(null);
}
}