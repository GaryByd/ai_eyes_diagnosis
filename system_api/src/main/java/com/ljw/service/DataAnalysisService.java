package com.ljw.service;


import java.util.List;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.entity.po.DataAnalysis;
import com.ljw.entity.dao.DataAnalysisQuery;
/**
 * @Description:  Service
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
public interface DataAnalysisService{

	/**
 	 * 根据条件查询列表
 	 */
	List<DataAnalysis> findListByParam(DataAnalysisQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(DataAnalysisQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<DataAnalysis> findListByPage(DataAnalysisQuery query);

	/**
 	 * 新增
 	 */
	Integer add(DataAnalysis bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<DataAnalysis> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<DataAnalysis> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	DataAnalysis getDataAnalysisById(Integer id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateDataAnalysisById(DataAnalysis bean, Integer id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteDataAnalysisById(Integer id);
}