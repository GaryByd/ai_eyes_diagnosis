package com.ljw.controller;


import java.util.List;

import com.ljw.service.TreatmentPlansService;
import com.ljw.entity.vo.ResponseVO;
import com.ljw.entity.po.TreatmentPlans;
import com.ljw.entity.dao.TreatmentPlansQuery;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: Controller
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
@RestController
@RequestMapping("/treatmentPlans")
public class TreatmentPlansController extends ABaseController {

    @Resource
    private TreatmentPlansService treatmentPlansService;

    @RequestMapping("/loadDataList")
    public ResponseVO loadDataList(@RequestBody TreatmentPlansQuery query) {

        return getSuccessResponseVO(treatmentPlansService.findListByPage(query));
    }

    /**
     * 新增
     */
    @PostMapping("/{diagnosisId}/treatment")
    public ResponseVO add(
            @PathVariable(value = "diagnosisId") Integer diagnosisId,
            @RequestBody TreatmentPlans bean) {
        // 设置诊断ID
        bean.setDiagnosisId(diagnosisId);
        // 调用服务添加治疗计划，服务中会获取当前登录用户并设置doctorId
        Integer result = this.treatmentPlansService.add(bean);
        return getSuccessResponseVO(null);
    }

    /**
     * 批量新增
     */
    @RequestMapping("/addBatch")
    public ResponseVO addBatch(@RequestBody List<TreatmentPlans> listBean) {
        this.treatmentPlansService.addBatch(listBean);
        return getSuccessResponseVO(null);
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("/addOrUpdateBatch")
    public ResponseVO addOrUpdateBatch(@RequestBody List<TreatmentPlans> listBean) {
        this.treatmentPlansService.addOrUpdateBatch(listBean);
        return getSuccessResponseVO(null);
    }

    /**
     * 根据 Id 查询
     */
    @RequestMapping("/getTreatmentPlansById/{id}")
    public ResponseVO getTreatmentPlansById(@PathVariable("id") Integer id) {
        return getSuccessResponseVO(treatmentPlansService.getTreatmentPlansById(id));
    }

    /**
     * 根据 Id 更新
     */
    @PutMapping("/updateTreatmentPlansById")
    public ResponseVO updateTreatmentPlansById(@RequestBody TreatmentPlans bean, @RequestParam Integer id) {
        this.treatmentPlansService.updateTreatmentPlansById(bean, id);
        return getSuccessResponseVO(null);
    }

    /**
     * 根据 Id 删除
     */
    @RequestMapping("/deleteTreatmentPlansById")
    public ResponseVO deleteTreatmentPlansById(Integer id) {
        this.treatmentPlansService.deleteTreatmentPlansById(id);
        return getSuccessResponseVO(null);
    }
}
