package com.ljw.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.ljw.client.FastApiModelAnalyzeClient;
import com.ljw.service.UploadService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class UploadServiceImpl implements UploadService {

    private final FastApiModelAnalyzeClient fastApiModelAnalyzeClient;
    /**
     * 处理文件上传逻辑
     */
    @Override
    public String handleFileUpload(MultipartFile leftFile, MultipartFile rightFile, String apiKey) {
        return fastApiModelAnalyzeClient.uploadFile(leftFile, rightFile, apiKey);
    }

    @Override
    public String handleFileBatchUpload(MultipartFile[] files, String apiKey) {
        return fastApiModelAnalyzeClient.batchUploadFiles(files, apiKey);
    }


    /**
     * 错误信息解析
     */
    private String parseError(Exception e) {
        if (e instanceof FeignException) {
            FeignException fe = (FeignException) e;
            String responseBody = fe.contentUTF8();
            // 尝试解析JSON格式的错误响应
            try {
                JsonNode node = new ObjectMapper().readTree(responseBody);
                if (node.has("error_code")) {
                    int code = node.get("error_code").asInt();
                    String msg = node.get("message").asText();
                    return String.format("服务端错误 [%d]: %s", code, msg);
                }
            } catch (JsonProcessingException ex) {
                log.error("解析错误响应失败", ex);
            }

            return "服务通信错误: " + responseBody;
        }
        return "系统内部错误: " + e.getMessage();
    }
}