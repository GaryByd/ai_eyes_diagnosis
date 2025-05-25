package com.ljw.minio;

import com.ljw.controller.ABaseController;
import com.ljw.exception.BusinessException;
import com.ljw.entity.vo.ResponseVO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/minio")
public class MinioController extends ABaseController {

    private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(MinioController.class);
    @Autowired
    private MinioService minioService;

    @PostMapping("/upload")
    public ResponseVO uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
            String filename = timestamp + "_" + originalFilename;
            String objectName = minioService.uploadFile(file, filename);
            String url = minioService.getFileUrl(objectName);
            Logger.info("文件上传成功", objectName);
            return getSuccessResponseVO(url);
        } catch (Exception e) {
            e.printStackTrace();
            return getFailResponseVO("上传失败: " + e.getMessage());
        }
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        try {
            InputStream stream = minioService.downloadFile(fileName);
            InputStreamResource resource = new InputStreamResource(stream);
            // 根据文件扩展名动态设置Content-Type
            MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;
            if (fileName.toLowerCase().endsWith(".jpg") || fileName.toLowerCase().endsWith(".jpeg")) {
                mediaType = MediaType.IMAGE_JPEG;
            } else if (fileName.toLowerCase().endsWith(".png")) {
                mediaType = MediaType.IMAGE_PNG;
            }
            return ResponseEntity.ok()
                    .contentType(mediaType)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .body(resource);
        } catch (Exception e) {
            throw new BusinessException("文件下载失败: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{fileName}")
    public ResponseVO deleteFile(@PathVariable String fileName) {
        try {
            minioService.deleteFile(fileName);
            Logger.info("文件删除成功", fileName);
            return getSuccessResponseVO(null);
        } catch (Exception e) {
            e.printStackTrace();
            return getFailResponseVO("删除失败: " + e.getMessage());
        }
    }


}