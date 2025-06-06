package com.ljw.enums;

/**
 * @Description: 响应参数
 * @Author: KunSpireUp
 * @Date: 3/27/2024 12:00 AM
 */
public enum ResponseCodeEnum {

	CODE_200(200, "请求成功"),
	CODE_404(404, "请求地址不能存在"),
	CODE_402(402, "用户名或密码错误"),
	CODE_600(600, "请求地址不能存在"),
	CODE_601(601, "请求参数错误"),
	CODE_602(602, "数据已存在"),
	CODE_500(500, "服务器返回错误，请联系管理员");

	private Integer code;

	private String msg;

	ResponseCodeEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
