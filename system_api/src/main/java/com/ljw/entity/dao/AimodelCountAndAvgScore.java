package com.ljw.entity.dao;

import lombok.Data;

/**
 * DATE: 2025/4/9
 * Author: lizhiyu
 */
@Data
public class AimodelCountAndAvgScore {

    private Integer id;

    private Integer totalDiagnosis;

    private String averageScore;

    public void setAverageScore(Double averageScore) {
        this.averageScore = String.format("%.2f", averageScore);
    }
}
