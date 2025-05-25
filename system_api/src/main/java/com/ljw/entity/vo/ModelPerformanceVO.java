package com.ljw.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DATE: 2025/4/9
 * Author: lizhiyu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelPerformanceVO {

    private Integer id;

    private String version;

    private String deployTime;

    private Integer totalDiagnosis;

    private String accuracy;

    private String averageScore;
}
