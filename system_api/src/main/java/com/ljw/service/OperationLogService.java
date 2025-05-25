package com.ljw.service;


import java.util.List;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.entity.po.OperationLog;
import com.ljw.entity.dao.OperationLogQuery;
/**
 * @Description:  Service
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
public interface OperationLogService{

	/**
 	 * 根据条件查询列表
 	 */
	List<OperationLog> findListByParam(OperationLogQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(OperationLogQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<OperationLog> findListByPage(OperationLogQuery query);

	/**
 	 * 新增
 	 */
	Integer add(OperationLog bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<OperationLog> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<OperationLog> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	OperationLog getOperationLogById(Integer id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateOperationLogById(OperationLog bean, Integer id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteOperationLogById(Integer id);
}