package com.ljw.controller;

import com.ljw.annotation.Log;
import com.ljw.constants.Constants;
import com.ljw.entity.dto.TokenUserInfoDTO;
import com.ljw.entity.vo.ResponseVO;
import com.ljw.enums.BusinessType;
import com.ljw.exception.BusinessException;
import com.ljw.redis.RedisComponent;
import com.ljw.service.DoctorService;
import com.ljw.utils.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * DATE: 2025/3/1
 * Author: lizhiyu
 */
@RestController
public class LoginController extends ABaseController{
    // 正则表达式，校验中国大陆的手机号（不带国际区号，以1开头，第二位是3-9之间的数字，后面跟着9位数字）
    private static final String PHONE_REGEX = "^1[3-9]\\d{9}$";

    // 编译正则表达式
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

    private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private DoctorService doctorService;

    @Resource
    private RedisComponent redisComponent;

    @PostMapping("/login")
    @Log(title = "用户登录", businessType = BusinessType.GRANT)
    public ResponseVO login(@RequestParam String phone,@RequestParam String code) {

        if(phone.equals("") || code.equals("") || phone == null || code == null){
            throw new BusinessException("手机号或验证码不能为空");
        }

        if(!isValidPhoneNumber(phone)){
            throw new BusinessException("手机号不合法");
        }

        TokenUserInfoDTO tokenUserInfoDTO = new TokenUserInfoDTO();
        if(phone.equals("admin") && code.equals("admin")){
            String token = StringUtils.encodeByMd5(phone + StringUtils.getRandomString(Constants.LENGTH_21));

            tokenUserInfoDTO.setRole("admin");
            tokenUserInfoDTO.setToken(token);
            tokenUserInfoDTO.setId(0);

            redisComponent.saveTokenUserInfoDTO(tokenUserInfoDTO);

            return getSuccessResponseVO(tokenUserInfoDTO);
        }

        tokenUserInfoDTO = doctorService.login(phone, code);

        redisComponent.saveTokenUserInfoDTO(tokenUserInfoDTO);

        return getSuccessResponseVO(tokenUserInfoDTO);
    }

    @GetMapping("/getCode/{phone}")
    @Log(title = "获取验证码", businessType = BusinessType.GRANT)
    public ResponseVO getCode(@PathVariable String phone){
        doctorService.getCode(phone);
        return getSuccessResponseVO("发送成功");
    }



    /**
     * 校验手机号是否合法
     * @param phoneNumber 手机号字符串
     * @return 如果手机号合法返回true，否则返回false
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        Matcher matcher = PHONE_PATTERN.matcher(phoneNumber);
        return matcher.matches();
    }

}
