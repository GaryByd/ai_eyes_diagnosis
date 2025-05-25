package com.ljw.test;

import com.ljw.constants.Constants;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * DATE: 2025/3/19
 * Author: lizhiyu
 */
@RestController("/test")
public class Test {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/redis/{token}")
    public void test(@PathVariable String token) {
        Object o = redisTemplate.opsForValue().get(Constants.REDIS_TOKEN_KEY + token);
        System.out.println(o);
    }
}
