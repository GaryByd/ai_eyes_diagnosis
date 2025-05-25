package com.ljw.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DATE: 2025/3/23
 * Author: lizhiyu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientStatisticsVO {
    private Integer totalCount;
    private Integer newPatientsCount;
    private AgeRangeCountVO ageRangeCountVO;
    private List<GenderCountVO> genderCountVO;
    private RegionCountVO regionCountVO;
}
