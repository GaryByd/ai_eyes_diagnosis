package com.ljw.controller;

import com.ljw.annotation.Log;
import com.ljw.constants.Constants;
import com.ljw.entity.dto.TokenUserInfoDTO;
import com.ljw.entity.vo.ResponseVO;
import com.ljw.enums.BusinessType;
import com.ljw.enums.ResponseCodeEnum;
import com.ljw.exception.BusinessException;
import com.ljw.redis.RedisComponent;
import com.ljw.utils.StringUtils;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/auth"})
public class AuthController extends ABaseController {
    @Resource
    private RedisComponent redisComponent;

    @PostMapping({"/login"})
    @Log(title = "管理员登录", businessType = BusinessType.GRANT)
    public ResponseVO login(@RequestParam String username, @RequestParam String password) {
        if (username.equals("admin") && password.equals("admin")) {
            TokenUserInfoDTO tokenUserInfoDTO = new TokenUserInfoDTO();
            tokenUserInfoDTO.setId(0);
            String token = StringUtils.encodeByMd5("admin" + StringUtils.getRandomString(Constants.LENGTH_21));
            tokenUserInfoDTO.setToken(token);
            tokenUserInfoDTO.setRole("admin");
            this.redisComponent.saveTokenUserInfoDTO(tokenUserInfoDTO);
            return this.getSuccessResponseVO(tokenUserInfoDTO);
        } else {
            throw new BusinessException(ResponseCodeEnum.CODE_402.getCode(), "用户名或密码错误");
        }
    }
}
