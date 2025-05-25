package com.ljw.controller;

import com.ljw.constants.Constants;
import com.ljw.entity.dto.TokenUserInfoDTO;
import com.ljw.entity.vo.ResponseVO;

import com.ljw.enums.ResponseCodeEnum;
import com.ljw.redis.RedisUtils;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 信息返回状态
 * @Author: KunSpireUp
 * @Date: 3/27/2024 12:24 AM
 */
public class ABaseController {

    @Resource
    private RedisUtils redisUtils;

    protected static final String STATUS_SUCCESS = "success";

    protected static final String STATUS_ERROR = "error";

    protected <T> ResponseVO getSuccessResponseVO(T t) {
        ResponseVO<T> responseVO = new ResponseVO<>();
        responseVO.setStatus(STATUS_SUCCESS);
        responseVO.setCode(ResponseCodeEnum.CODE_200.getCode());
        responseVO.setInfo(ResponseCodeEnum.CODE_200.getMsg());
        responseVO.setData(t);
        return responseVO;
    }
    //失败
    protected <T> ResponseVO getFailResponseVO(T t) {
        ResponseVO<T> responseVO = new ResponseVO<>();
        responseVO.setStatus(STATUS_ERROR);
        responseVO.setCode(ResponseCodeEnum.CODE_500.getCode());
        responseVO.setInfo(ResponseCodeEnum.CODE_500.getMsg());
        responseVO.setData(t);
        return responseVO;
    }

    protected TokenUserInfoDTO getTokenUserInfoDTO(HttpServletRequest request) {
        String token = request.getHeader("token");
        TokenUserInfoDTO tokenUserInfoDTO = (TokenUserInfoDTO) redisUtils.get(Constants.REDIS_TOKEN_KEY + token);
        return tokenUserInfoDTO;
    }
}
