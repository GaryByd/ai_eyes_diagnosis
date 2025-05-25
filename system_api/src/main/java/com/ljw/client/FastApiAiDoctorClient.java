package com.ljw.client;

import com.ljw.entity.dto.ChatForm;
import com.ljw.entity.vo.AiRecommendationRequest;
import com.ljw.entity.vo.AiRecommendationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "ai-doctor-service"
)
public interface FastApiAiDoctorClient {
    @PostMapping(
            value = "/api/eye-doctor/chat"
    )
    String eye_doctor_chat(
           @RequestBody ChatForm chatForm
    );

    @PostMapping(
            value = "/api/eye-doctor/recommendations"
    )
    AiRecommendationResponse getRecommendations(
           @RequestBody AiRecommendationRequest request
    );
}