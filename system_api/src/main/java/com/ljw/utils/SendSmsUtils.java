package com.ljw.utils;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.aliyuncs.dysmsapi.model.v20170525.*;
import com.ljw.constants.Constants;
import com.ljw.exception.BusinessException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class SendSmsUtils {

    @Resource
    private RedisTemplate redisTemplate;

    public Boolean sendSms(String phone) {
        String randomNumber = StringUtils.getRandomNumber(6);
        Boolean absent = redisTemplate.opsForValue().setIfAbsent(Constants.PHONE_VERIFY_CODE + phone, randomNumber, 60 * 5, TimeUnit.SECONDS);
        if(!absent){
            throw new BusinessException("验证码已发送，请勿重复发送");
        }
        String accessKeyId = System.getenv("ALIYUN_ACCESS_KEY_ID");
        String accessKeySecret = System.getenv("ALIYUN_ACCESS_KEY_SECRET");
        DefaultProfile profile = DefaultProfile.getProfile("cn-shenzhen",
                accessKeyId, accessKeySecret);

        IAcsClient client = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(phone);
        request.setSignName("阿里云短信测试");
        request.setTemplateCode("SMS_154950909");

        request.setTemplateParam("{\"code\":\"" +
                randomNumber +
                "\"}");

        try {
            SendSmsResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return true;
    }
}