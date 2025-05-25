package com.ljw.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DATE: 2025/3/22
 * Author: lizhiyu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisStatisticsVO {
    /**
     * "period": "2025-01-01 至 2025-03-01",
     *     "total_count": 450,
     *     "by_disease": [
     *       {
     *         "disease_name": "糖尿病视网膜病变",
     *         "count": 180,
     *         "percentage": 0.4
     *       }
     *     ],
     *     "by_status": [
     *       {
     *         "status": "confirmed",
     *         "count": 400,
     *         "percentage": 0.89
     *       }
     *     ],
     *     "by_date": [
     *       {
     *         "date": "2025-02-15",
     *         "count": 15
     *       }
     *     ]
     */
    private Integer total_count;
    private List<DiseaseCountVO> by_disease;
    private List<StatusCountVO> by_status;
    private List<DateCountVO> by_date;
}
