package com.ljw.mapper;

import com.ljw.entity.dao.AimodelCountAndAvgScore;
import com.ljw.entity.vo.DateCountVO;
import com.ljw.entity.vo.DiseaseCountVO;
import com.ljw.entity.vo.DoctorDiagnosisCountVO;
import com.ljw.entity.vo.StatusCountVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:  Mapper
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
public interface DiagnosisReportMapper<T, P> extends BaseMapper {

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

	T selectRecentDiagnosis(@Param("id")Integer id);

	List<DiseaseCountVO> findDiseaseCount(@Param("startDate")String startDate, @Param("endDate")String endDate,@Param("diseaseCategory")String diseaseCategory,@Param("status")String status);

	List<StatusCountVO> findStatusCount(@Param("startDate")String startDate, @Param("endDate")String endDate,@Param("diseaseCategory")String diseaseCategory,@Param("status")String status);

	List<DateCountVO> findDateCount(@Param("startDate")String startDate, @Param("endDate")String endDate,@Param("diseaseCategory")String diseaseCategory,@Param("status")String status);

	Integer recentMonthPatientsCount();

    void updateScoreById(@Param("id") Integer id, @Param("score") Integer score);

	List<AimodelCountAndAvgScore> countByAimodelIdAndAvgByScore();

	List<DoctorDiagnosisCountVO> getDoctorConfirmedCount();
}