package com.ljw.service;


import java.util.List;

import com.ljw.entity.vo.EyeImagesPositionVO;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.entity.po.EyeImages;
import com.ljw.entity.dao.EyeImagesQuery;
/**
 * @Description:  Service
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
public interface EyeImagesService{

	/**
 	 * 根据条件查询列表
 	 */
	List<EyeImages> findListByParam(EyeImagesQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(EyeImagesQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<EyeImages> findListByPage(EyeImagesQuery query);

	/**
 	 * 新增
 	 */
	Integer add(EyeImages bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<EyeImages> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<EyeImages> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	EyeImages getEyeImagesById(Integer id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateEyeImagesById(EyeImages bean, Integer id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteEyeImagesById(Integer id);

	List<EyeImagesPositionVO> findCountByEyePosition();
}