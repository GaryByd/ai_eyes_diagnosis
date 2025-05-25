package com.ljw.controller;


import java.util.List;
import com.ljw.service.OperationLogService;
import com.ljw.entity.vo.ResponseVO;
import com.ljw.entity.po.OperationLog;
import com.ljw.entity.dao.OperationLogQuery;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
/**
 * @Description:  Controller
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
@RestController
@RequestMapping("/operationLog")
public class OperationLogController extends ABaseController{

	@Resource
	private OperationLogService operationLogService;

	@PostMapping("/loadDataList")
	public ResponseVO loadDataList(@RequestBody OperationLogQuery query) {
		return getSuccessResponseVO(operationLogService.findListByPage(query));
	}

	/**
 	 * 新增
 	 */
	@RequestMapping("/add")
	public ResponseVO add(OperationLog bean) {
		Integer result = this.operationLogService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<OperationLog> listBean) {
		this.operationLogService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<OperationLog> listBean) {
		this.operationLogService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@RequestMapping("/getOperationLogById")
	public ResponseVO getOperationLogById(Integer id) {
		return getSuccessResponseVO(operationLogService.getOperationLogById(id));}

	/**
 	 * 根据 Id 更新
 	 */
	@RequestMapping("/updateOperationLogById")
	public ResponseVO updateOperationLogById(OperationLog bean, Integer id) {
		this.operationLogService.updateOperationLogById(bean, id);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 Id 删除
 	 */
	@RequestMapping("/deleteOperationLogById")
	public ResponseVO deleteOperationLogById(Integer id) {
		this.operationLogService.deleteOperationLogById(id);
		return getSuccessResponseVO(null);
	}
}