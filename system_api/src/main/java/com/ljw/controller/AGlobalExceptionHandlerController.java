package com.ljw.controller;

import com.ljw.entity.vo.ResponseVO;;

import com.ljw.enums.ResponseCodeEnum;;

import com.ljw.exception.BusinessException;;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

import java.net.BindException;

/**
 * @Description: 全局异常处理
 * @Author: KunSpireUp
 * @Date: 3/27/2024 12:52 AM
 */
@RestControllerAdvice
public class AGlobalExceptionHandlerController extends ABaseController{

	private static final Logger logger = LoggerFactory.getLogger(AGlobalExceptionHandlerController.class);

	@ExceptionHandler(value = Exception.class)
	Object handelException(Exception e, HttpServletRequest request) {
		logger.error("请求错误，请求地址{},错误信息:", request.getRequestURL(), e);
		ResponseVO ajaxResponse = new ResponseVO();
		// 404
		if (e instanceof NoHandlerFoundException) {
			ajaxResponse.setCode(ResponseCodeEnum.CODE_404.getCode());
			ajaxResponse.setInfo(ResponseCodeEnum.CODE_404.getMsg());
			ajaxResponse.setStatus(STATUS_ERROR);
		} else if (e instanceof BusinessException) {
			// 业务错误
			BusinessException businessException = (BusinessException) e;
			ajaxResponse.setCode(businessException.getCode());
			ajaxResponse.setInfo(businessException.getMessage());
			ajaxResponse.setStatus(STATUS_ERROR);
		} else if (e instanceof BindException) {
			// 参数类型错误
			ajaxResponse.setCode(ResponseCodeEnum.CODE_600.getCode());
			ajaxResponse.setInfo(ResponseCodeEnum.CODE_600.getMsg());
			ajaxResponse.setStatus(STATUS_ERROR);
		} else if (e instanceof DuplicateKeyException) {
			// 主键冲突
			ajaxResponse.setCode(ResponseCodeEnum.CODE_601.getCode());
			ajaxResponse.setInfo(ResponseCodeEnum.CODE_601.getMsg());
			ajaxResponse.setStatus(STATUS_ERROR);
		} else {
			ajaxResponse.setCode(ResponseCodeEnum.CODE_500.getCode());
			ajaxResponse.setInfo(ResponseCodeEnum.CODE_500.getMsg());
			ajaxResponse.setStatus(STATUS_ERROR);

		}
		return ajaxResponse;

	}
}
