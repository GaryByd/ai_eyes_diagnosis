package com.ljw.client;

import com.ljw.config.FeignMultipartSupportConfig;
import com.ljw.fallback.FlastUploadFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(
        name = "doctor-analyze-service",
        configuration = FeignMultipartSupportConfig.class,
        fallbackFactory = FlastUploadFallbackFactory.class
)
public interface FastApiModelAnalyzeClient {

    @PostMapping(
            value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    String uploadFile(
            @RequestPart("left_eye") MultipartFile leftFile,
            @RequestPart("right_eye") MultipartFile RightFile,
            @RequestHeader("X-API-Key") String apiKey
    );

    // 新增批量上传文件接口
    @PostMapping(
            value = "/batch-upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    String batchUploadFiles(
            @RequestPart("files") MultipartFile[] files,
            @RequestHeader("X-API-Key") String apiKey
    );
}