package com.ljw.mapper;

import com.ljw.entity.vo.EyeImagesPositionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:  Mapper
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
public interface EyeImagesMapper<T, P> extends BaseMapper {

	/**
 	 * 根据 Id 查询
 	 */
	T selectById(@Param("id")Integer id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateById(@Param("bean") T t, @Param("id")Integer id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteById(@Param("id")Integer id);

    List<EyeImagesPositionVO> selectCountByEyePosition();

    List<T> selectByDiagnosisById(@Param("diagnosisReportId")Integer diagnosisReportId);
}