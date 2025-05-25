package com.ljw.service;


import java.util.List;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.entity.po.Cases;
import com.ljw.entity.dao.CasesQuery;
/**
 * @Description:  Service
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
public interface CasesService{

	/**
 	 * 根据条件查询列表
 	 */
	List<Cases> findListByParam(CasesQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(CasesQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<Cases> findListByPage(CasesQuery query);

	/**
 	 * 新增
 	 */
	Integer add(Cases bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<Cases> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<Cases> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	Cases getCasesById(Integer id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateCasesById(Cases bean, Integer id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteCasesById(Integer id);


}