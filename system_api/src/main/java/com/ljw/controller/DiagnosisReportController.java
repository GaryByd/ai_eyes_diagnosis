package com.ljw.controller;


import java.util.ArrayList;
import java.util.List;

import com.ljw.annotation.Log;
import com.ljw.entity.vo.AllVO;
import com.ljw.enums.BusinessType;
import com.ljw.service.DiagnosisReportService;
import com.ljw.entity.vo.ResponseVO;
import com.ljw.entity.po.DiagnosisReport;
import com.ljw.entity.dao.DiagnosisReportQuery;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @Description:  Controller
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
@RestController
@RequestMapping("/diagnosisReport")
public class DiagnosisReportController extends ABaseController	{

	private static Logger Logger = org.slf4j.LoggerFactory.getLogger(DiagnosisReportController.class);

	@Resource
	private DiagnosisReportService diagnosisReportService;

	@PostMapping("/loadDataList")
	@Log(title = "诊断报告", businessType = BusinessType.SELECT)
	public ResponseVO loadDataList(@RequestBody DiagnosisReportQuery query) {
		return getSuccessResponseVO(diagnosisReportService.findListByPage(query));
	}

	@PutMapping("/score")
	@Log(title = "诊断报告", businessType = BusinessType.UPDATE)
	public ResponseVO scoreById(@RequestParam Integer id,@RequestParam Integer score) {
		diagnosisReportService.scoreById(id,score);
		return getSuccessResponseVO(null);
	}

	@GetMapping("/getByIds")
	@Log(title = "诊断报告", businessType = BusinessType.SELECT)
	public ResponseVO getByIds(@RequestParam String ids) {
		String[] split = ids.split(",");
		List<DiagnosisReport> list = new ArrayList<>();
		for (String s : split) {
			DiagnosisReport report = diagnosisReportService.getDiagnosisReportById(Integer.parseInt(s));
			list.add(report);
		}
		return getSuccessResponseVO(list);
	}

	/**
 	 * 新增
 	 */
	@PostMapping("/reports")
	@Log(title = "诊断报告", businessType = BusinessType.INSERT)
	public ResponseVO add(@RequestBody DiagnosisReport bean) {
		Integer result = this.diagnosisReportService.add(bean);
		return getSuccessResponseVO(bean.getId());
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	@Log(title = "诊断报告", businessType = BusinessType.INSERT)
	public ResponseVO addBatch(@RequestBody List<DiagnosisReport> listBean) {
		this.diagnosisReportService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<DiagnosisReport> listBean) {
		this.diagnosisReportService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@GetMapping("/getDiagnosisReportById")
	@Log(title = "诊断报告", businessType = BusinessType.SELECT)
	public ResponseVO getDiagnosisReportById(@RequestParam Integer id) {
		return getSuccessResponseVO(diagnosisReportService.getAllById(id));}

	/**
 	 * 根据 Id 更新
 	 */
	@PutMapping("/updateDiagnosisReportByIdV2")
	@Log(title = "诊断报告", businessType = BusinessType.UPDATE)
	public ResponseVO updateDiagnosisReportById(@RequestBody AllVO allVO,@RequestParam Integer id) {
    Logger.info("updateDiagnosisReportById allVO:{}", allVO);
    this.diagnosisReportService.updateDiagnosisReportWithRelations(allVO, id);
    return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 Id 删除
 	 */
	@DeleteMapping("/deleteDiagnosisReportById")
	@Log(title = "诊断报告", businessType = BusinessType.DELETE)
	public ResponseVO deleteDiagnosisReportById(Integer id) {
		this.diagnosisReportService.deleteDiagnosisReportById(id);
		return getSuccessResponseVO(null);
	}
}