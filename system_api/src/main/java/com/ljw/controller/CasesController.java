package com.ljw.controller;


import java.util.List;

import com.ljw.annotation.Log;
import com.ljw.enums.BusinessType;
import com.ljw.service.CasesService;
import com.ljw.entity.vo.ResponseVO;
import com.ljw.entity.po.Cases;
import com.ljw.entity.dao.CasesQuery;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @Description:  Controller
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
@RestController
@RequestMapping("/cases")
public class CasesController extends ABaseController{

	@Resource
	private CasesService casesService;

	@PostMapping("/loadDataList")
	@Log(title = "病例", businessType = BusinessType.SELECT)
	public ResponseVO loadDataList(@RequestBody CasesQuery query) {
		return getSuccessResponseVO(casesService.findListByPage(query));
	}

	/**
 	 * 新增
 	 */
	@RequestMapping("/add")
	@Log(title = "病例", businessType = BusinessType.INSERT)
	public ResponseVO add(@RequestBody Cases bean) {
		Integer result = this.casesService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	@Log(title = "病例", businessType = BusinessType.INSERT)
	public ResponseVO addBatch(@RequestBody List<Cases> listBean) {
		this.casesService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Cases> listBean) {
		this.casesService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Log(title = "病例", businessType = BusinessType.SELECT)
	@RequestMapping("/getCasesById/{id}")
	public ResponseVO getCasesById(@PathVariable Integer id) {
		return getSuccessResponseVO(casesService.getCasesById(id));}

	/**
 	 * 根据 Id 更新
 	 */
	@PutMapping("/updateCasesById")
	@Log(title = "病例", businessType = BusinessType.UPDATE)
	public ResponseVO updateCasesById(@RequestBody Cases bean, Integer id) {
		this.casesService.updateCasesById(bean, id);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 Id 删除
 	 */
	@DeleteMapping("/deleteCasesById")
	@Log(title = "病例", businessType = BusinessType.DELETE)
	public ResponseVO deleteCasesById(@RequestParam Integer id) {
		this.casesService.deleteCasesById(id);
		return getSuccessResponseVO(null);
	}
}