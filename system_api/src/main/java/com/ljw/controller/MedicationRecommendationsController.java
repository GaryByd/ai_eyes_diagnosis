package com.ljw.controller;


import java.util.ArrayList;
import java.util.List;
import com.ljw.service.MedicationRecommendationsService;
import com.ljw.entity.vo.ResponseVO;
import com.ljw.entity.po.MedicationRecommendations;
import com.ljw.entity.dao.MedicationRecommendationsQuery;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @Description:  Controller
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
@RestController
@RequestMapping("/medicationRecommendations")
public class MedicationRecommendationsController extends ABaseController{

	@Resource
	private MedicationRecommendationsService medicationRecommendationsService;


	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(@RequestBody MedicationRecommendationsQuery query) {
		return getSuccessResponseVO(medicationRecommendationsService.findListByPage(query));
	}
	@GetMapping("/getByIds")
	public ResponseVO getByIds(@RequestParam String ids) {
		String[] split = ids.split(",");
		List<MedicationRecommendations> list = new ArrayList<>();
		for (String s : split) {
			MedicationRecommendations m = medicationRecommendationsService.findById(Integer.parseInt(s));
			list.add(m);
		}
		return getSuccessResponseVO(list);
	}

	/**
 	 * 新增
 	 */
	@PostMapping("/{diagnosisId}/medication")
	public ResponseVO add(
			@PathVariable(value = "diagnosisId") Integer diagnosisId,
			@RequestBody MedicationRecommendations bean
	) {
		bean.setDiagnosisId(diagnosisId);
		Integer result = this.medicationRecommendationsService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<MedicationRecommendations> listBean) {
		this.medicationRecommendationsService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<MedicationRecommendations> listBean) {
		this.medicationRecommendationsService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@RequestMapping("/getMedicationRecommendationsById/{id}")
	public ResponseVO getMedicationRecommendationsById(@PathVariable("id") Integer id) {
		return getSuccessResponseVO(medicationRecommendationsService.getMedicationRecommendationsById(id));}

	/**
 	 * 根据 Id 更新
 	 */
	@PutMapping("/updateMedicationRecommendationsById")
	public ResponseVO updateMedicationRecommendationsById(@RequestBody MedicationRecommendations bean,
														 @RequestParam Integer id) {
		this.medicationRecommendationsService.updateMedicationRecommendationsById(bean, id);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 Id 删除
 	 */
	@RequestMapping("/deleteMedicationRecommendationsById")
	public ResponseVO deleteMedicationRecommendationsById(Integer id) {
		this.medicationRecommendationsService.deleteMedicationRecommendationsById(id);
		return getSuccessResponseVO(null);
}
}