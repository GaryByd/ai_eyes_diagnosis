package com.ljw.service;

import com.ljw.entity.vo.AiRecommendationResponse;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.entity.po.Aimodel;
import com.ljw.entity.dao.AimodelQuery;

import java.util.List;

/**
 * @Description:  Service
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
public interface AimodelService{

	/**
 	 * 根据条件查询列表
 	 */
	List<Aimodel> findListByParam(AimodelQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(AimodelQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<Aimodel> findListByPage(AimodelQuery query);

	/**
 	 * 新增
 	 */
	Integer add(Aimodel bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<Aimodel> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<Aimodel> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	Aimodel getAimodelById(Integer id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateAimodelById(Aimodel bean, Integer id);

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteAimodelById(Integer id);

    Aimodel selectMaxId();

    AiRecommendationResponse getRecommendations(Integer diagnosisReportId);

}