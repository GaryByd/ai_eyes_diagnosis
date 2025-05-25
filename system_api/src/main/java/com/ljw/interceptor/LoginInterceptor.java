package com.ljw.interceptor;

import com.ljw.constants.Constants;
import com.ljw.entity.dto.TokenUserInfoDTO;
import com.ljw.utils.ThreadLocalUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private RedisTemplate redisTemplate;
    ThreadLocal threadLocal = new ThreadLocal();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 检查Session中是否存在用户信息
        String token = request.getHeader("token");
        if (token != null) {
            Object o = redisTemplate.opsForValue().get(Constants.REDIS_TOKEN_KEY + token);
            if (o != null) {
                TokenUserInfoDTO tokenUserInfoDTO = (TokenUserInfoDTO) o;
                ThreadLocalUtils.set(tokenUserInfoDTO);
                return true; // 已登录，放行
            }
        }

        // 处理未登录的情况
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("{\"code\":401, \"message\":\"未登录\"}");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        return false; // 拦截请求
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 请求结束后清理 ThreadLocal
        ThreadLocalUtils.remove();
    }
}