package com.ljw.entity.vo;

import com.ljw.entity.po.*;
import lombok.Data;

import java.util.List;

/**
 * DATE: 2025/3/30
 * Author: lizhiyu
 */
@Data
public class AllVO {
    private DiagnosisReport diagnosisReport;
    private Patient patient;
    private Doctor doctor;
    private List<EyeImages> eyeImagesList;
    private List<TreatmentPlans> treatmentPlansList;
    private List<MedicationRecommendations> medicationRecommendationsList;
    private Aimodel aimodel;
}
