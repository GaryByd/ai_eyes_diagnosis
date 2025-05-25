package com.ljw.service;


import java.util.List;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.entity.po.TreatmentPlans;
import com.ljw.entity.dao.TreatmentPlansQuery;
/**
 * @Description:  Service
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
public interface TreatmentPlansService{

	/**
 	 * 根据条件查询列表
 	 */
	List<TreatmentPlans> findListByParam(TreatmentPlansQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(TreatmentPlansQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<TreatmentPlans> findListByPage(TreatmentPlansQuery query);

	/**
 	 * 新增
 	 */
	Integer add(TreatmentPlans bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<TreatmentPlans> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<TreatmentPlans> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	TreatmentPlans getTreatmentPlansById(Integer id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateTreatmentPlansById(TreatmentPlans bean, Integer id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteTreatmentPlansById(Integer id);
}