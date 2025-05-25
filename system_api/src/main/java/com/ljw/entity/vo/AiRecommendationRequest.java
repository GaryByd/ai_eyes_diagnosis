package com.ljw.entity.vo;

import lombok.Data;

@Data
public class AiRecommendationRequest {
    private String disease_name;
    private String disease_category;
    private String result;
    private PatientInfo patient_info;
    private boolean stream;

    @Data
    public static class PatientInfo {
        private String name;
        private String sex;
        private int age;
    }
}