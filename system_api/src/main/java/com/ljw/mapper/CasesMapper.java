package com.ljw.mapper;

import com.ljw.entity.po.Cases;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Description:  Mapper
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
public interface CasesMapper<T, P> extends BaseMapper {

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
	/**
 	 * 根据条件查询列表
 	 */
	@Select("SELECT * FROM cases WHERE patient_id = #{patientId} AND status not in ('archived', 'deleted')")
	Cases selectByPatinetId(Integer patientId);
}