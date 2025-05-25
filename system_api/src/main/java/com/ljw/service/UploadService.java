package com.ljw.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UploadService {

    /**
     * 处理文件上传逻辑
     */
    String handleFileUpload(MultipartFile leftFile, MultipartFile rightFile, String apiKey);

    String handleFileBatchUpload(MultipartFile[] files, String apiKey);
}