package com.ljw.controller;


import java.util.List;

import com.ljw.service.EyeImagesService;
import com.ljw.entity.vo.ResponseVO;
import com.ljw.entity.po.EyeImages;
import com.ljw.entity.dao.EyeImagesQuery;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: Controller
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
@RestController
@RequestMapping("/eyeImages")
public class EyeImagesController extends ABaseController {

    @Resource
    private EyeImagesService eyeImagesService;

    @RequestMapping()
    public ResponseVO loadDataList(EyeImagesQuery query) {
        return getSuccessResponseVO(eyeImagesService.findListByPage(query));
    }

    /**
     * 新增
     */
    @PostMapping("/{diagnosisId}/add")
    public ResponseVO add(
			@PathVariable("diagnosisId") Integer diagnosisId,
			@RequestBody EyeImages bean) {
		bean.setDignosisReportId(diagnosisId);
        Integer result = this.eyeImagesService.add(bean);
        return getSuccessResponseVO(null);
    }

    /**
     * 批量新增
     */
    @PostMapping("/addBatch")
    public ResponseVO addBatch(@RequestBody List<EyeImages> listBean) {
        this.eyeImagesService.addBatch(listBean);
        return getSuccessResponseVO(null);
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("/addOrUpdateBatch")
    public ResponseVO addOrUpdateBatch(@RequestBody List<EyeImages> listBean) {
        this.eyeImagesService.addOrUpdateBatch(listBean);
        return getSuccessResponseVO(null);
    }

    /**
     * 根据 Id 查询
     */
    @RequestMapping("{id}")
    public ResponseVO getEyeImagesById(@PathVariable Integer id) {
        return getSuccessResponseVO(eyeImagesService.getEyeImagesById(id));
    }

    /**
     * 根据 Id 更新
     */
    @RequestMapping("/updateEyeImagesById")
    public ResponseVO updateEyeImagesById(EyeImages bean, Integer id) {
        this.eyeImagesService.updateEyeImagesById(bean, id);
        return getSuccessResponseVO(null);
    }

    /**
     * 根据 Id 删除
     */
    @DeleteMapping("/{id}/delete")
    public ResponseVO deleteEyeImagesById(@PathVariable Integer id) {
        this.eyeImagesService.deleteEyeImagesById(id);
        return getSuccessResponseVO(null);
    }

}