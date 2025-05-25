package com.ljw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * DATE: 2025/2/27
 * Author: lizhiyu
 */
@SpringBootApplication(scanBasePackages = "com.ljw")
@MapperScan("com.ljw.mapper")
@EnableFeignClients("com.ljw.client")
@EnableDiscoveryClient  // 开启服务发现
@EnableScheduling
public class AIEyesDiagnosisApplication {
    public static void main(String[] args) {
        SpringApplication.run(AIEyesDiagnosisApplication.class, args);
    }
}
