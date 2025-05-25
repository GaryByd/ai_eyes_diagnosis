package com.ljw.controller;

import com.ljw.entity.dao.AimodelQuery;
import com.ljw.entity.po.Aimodel;
import com.ljw.service.AimodelService;
import com.ljw.entity.vo.AiRecommendationResponse;
import com.ljw.entity.vo.ResponseVO;
import com.ljw.service.UploadService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/aimodel")
public class AimodelController extends ABaseController {

    @Resource
    private AimodelService aimodelService;

    @Resource
    private UploadService uploadService;

    /**
     * 测试端点1：真实文件上传
     * 使用方式：通过Postman或表单上传文件
     */
    @PostMapping("/predict")
    public String testFileUpload(
            @RequestParam("left_eye") MultipartFile leftEye,
            @RequestParam("right_eye") MultipartFile rightEye,
            @RequestHeader(value = "X-API-Key", required = false) String apiKey) {
        System.out.printf("收到文件上传请求，文件名:" + rightEye.getName());
        System.out.printf("收到文件上传请求，文件名:" + leftEye.getName());
        return uploadService.handleFileUpload(leftEye, rightEye,apiKey);
    }

    /**
     * 批量上传
     * @param files 文件数组 通过Postman或表单上传文件
     * @return
     */
    @PostMapping("/batchUpload")
    public String batchUpload(
            @RequestParam("files") MultipartFile[] files,
            @RequestHeader(value = "X-API-Key", required = false) String apiKey
    ) {
        return uploadService.handleFileBatchUpload(files,apiKey);
    }
    @RequestMapping("/getRecommendations")
    public ResponseVO getRecommendations(@RequestParam("diagnosisReportId") Integer diagnosisReportId) {
        AiRecommendationResponse response = aimodelService.getRecommendations(diagnosisReportId);
        return getSuccessResponseVO(response);
    }
    @RequestMapping("/loadDataList")
    public ResponseVO loadDataList(AimodelQuery query) {
        return getSuccessResponseVO(aimodelService.findListByPage(query));
    }

    /**
     * 新增
     */
    @RequestMapping("/add")
    public ResponseVO add(@RequestBody Aimodel bean) {
        Integer result = this.aimodelService.add(bean);
        return getSuccessResponseVO(null);
    }

    /**
     * 批量新增
     */
    @RequestMapping("/addBatch")
    public ResponseVO addBatch(@RequestBody List<Aimodel> listBean) {
        this.aimodelService.addBatch(listBean);
        return getSuccessResponseVO(null);
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("/addOrUpdateBatch")
    public ResponseVO addOrUpdateBatch(@RequestBody List<Aimodel> listBean) {
        this.aimodelService.addOrUpdateBatch(listBean);
        return getSuccessResponseVO(null);
    }

    /**
     * 根据 Id 查询
     */
    @RequestMapping("/getAimodelById/{id}")
    public ResponseVO getAimodelById(@PathVariable("id") Integer id) {
        return getSuccessResponseVO(aimodelService.getAimodelById(id));}

    /**
     * 根据 Id 更新
     */
    @RequestMapping("/updateAimodelById/{id}")
    public ResponseVO updateAimodelById(Aimodel bean, @PathVariable("id") Integer id) {
        this.aimodelService.updateAimodelById(bean, id);
        return getSuccessResponseVO(null);
    }

    /**
     * 根据 Id 删除
     */
    @RequestMapping("/deleteAimodelById/{id}")
    public ResponseVO deleteAimodelById(@PathVariable("id") Integer id) {
        this.aimodelService.deleteAimodelById(id);
        return getSuccessResponseVO(null);
    }




}