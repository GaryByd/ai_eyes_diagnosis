package com.ljw.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class AiRecommendationResponse {
    private List<Medication> medications;
    private TreatmentPlan treatment_plan;

    @Data
    public static class Medication {
        private String medication_name;
        private String dosage;
        private String frequency;
        private String side_effects;
    }

    @Data
    public static class TreatmentPlan {
        private String treatment_type;
        private String treatment_detail;
    }
}