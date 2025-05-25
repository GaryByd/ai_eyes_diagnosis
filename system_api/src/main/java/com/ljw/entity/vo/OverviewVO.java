package com.ljw.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OverviewVO {
    private Integer total_patients;
    private Integer total_doctors;
    private Integer total_diagnoses;
    private Integer recent_diagnoses;
    private String diagnosis_accuracy;
    private String ai_model_version;
}