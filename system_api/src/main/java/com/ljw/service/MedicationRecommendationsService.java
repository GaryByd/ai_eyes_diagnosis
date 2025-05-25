package com.ljw.service;


import java.util.List;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.entity.po.MedicationRecommendations;
import com.ljw.entity.dao.MedicationRecommendationsQuery;
/**
 * @Description:  Service
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
public interface MedicationRecommendationsService{

	/**
 	 * 根据条件查询列表
 	 */
	List<MedicationRecommendations> findListByParam(MedicationRecommendationsQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(MedicationRecommendationsQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<MedicationRecommendations> findListByPage(MedicationRecommendationsQuery query);

	/**
 	 * 新增
 	 */
	Integer add(MedicationRecommendations bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<MedicationRecommendations> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<MedicationRecommendations> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	MedicationRecommendations getMedicationRecommendationsById(Integer id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateMedicationRecommendationsById(MedicationRecommendations bean, Integer id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteMedicationRecommendationsById(Integer id);

    MedicationRecommendations findById(int parseInt);
}