package com.ljw.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ljw.entity.inner.DialogueInfo;
import com.ljw.entity.po.MedicationRecommendations;
import com.ljw.entity.po.TreatmentPlans;

import java.util.ArrayList;

public class ChatForm {
    @JsonProperty("disease_name")
    private String diagnosisName;
    @JsonProperty("disease_category")
    private String diagnosisCategory;
    @JsonProperty("result")
    private String result;
    @JsonProperty("remark")
    private String remark;
    @JsonProperty("treatment_plan")
    private TreatmentPlans treatmentPlan;
    @JsonProperty("medications")
    private ArrayList<MedicationRecommendations> medications;
    @JsonProperty("previous_conversations")
    private ArrayList<DialogueInfo> previousConversations;
    @JsonProperty("question")
    private String question;
    @JsonProperty("stream")
    private boolean stream;


}