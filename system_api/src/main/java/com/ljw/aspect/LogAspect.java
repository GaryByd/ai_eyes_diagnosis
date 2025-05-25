package com.ljw.aspect;

import com.ljw.annotation.Log;
import com.ljw.async.AsyncFactory;
import com.ljw.entity.dto.TokenUserInfoDTO;
import com.ljw.entity.po.OperationLog;
import com.ljw.enums.BusinessStatus;
import com.ljw.utils.IpUtils;
import com.ljw.async.AsyncManager;
import com.ljw.utils.ServletUtils;
import com.ljw.utils.ThreadLocalUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 计算操作消耗时间
     */
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new NamedThreadLocal<Long>("Cost Time");

    /**
     * 处理请求前执行
     */
    @Before(value = "@annotation(controllerLog)")
    public void boBefore(JoinPoint joinPoint, Log controllerLog) {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "@annotation(controllerLog)", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Log controllerLog, Object jsonResult) {
        handleLog(joinPoint, controllerLog, null, jsonResult);
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param e         异常
     */
    @AfterThrowing(value = "@annotation(controllerLog)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Log controllerLog, Exception e) {
        handleLog(joinPoint, controllerLog, e, null);
    }

    protected void handleLog(final JoinPoint joinPoint, Log controllerLog, final Exception e, Object jsonResult) {
        try {
            // 获取当前的用户
            TokenUserInfoDTO tokenUserInfoDTO = ThreadLocalUtils.get(TokenUserInfoDTO.class);
            if (tokenUserInfoDTO == null) tokenUserInfoDTO = new TokenUserInfoDTO();
            // *========数据库日志=========*//
            OperationLog operationLog = new OperationLog();
            operationLog.setStatus(BusinessStatus.SUCCESS.ordinal());
            //设置请求的用户id和类型
            operationLog.setUserId(tokenUserInfoDTO.getId());
            operationLog.setRole(tokenUserInfoDTO.getRole());
            // 请求的地址
            String ip = IpUtils.getIpAddr();
            operationLog.setOperIp(ip);
            operationLog.setRequestUrl(StringUtils.substring(ServletUtils.getRequest().getRequestURI(), 0, 255));

            if (e != null) {
                operationLog.setStatus(BusinessStatus.FAIL.ordinal());
                operationLog.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
            }
            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            operationLog.setMethod(className + "." + methodName + "()");
            // 设置BusinessType
            operationLog.setBusinessType(controllerLog.businessType().name());
            // 设置标题
            operationLog.setTitle(controllerLog.title());
            // 设置消耗时间
            operationLog.setCostTime(System.currentTimeMillis() - TIME_THREADLOCAL.get());
            //设置创建时间

            operationLog.setCreateTime(new Date());
            // 保存数据库
            AsyncManager.me().execute(AsyncFactory.recordOper(operationLog));
        } catch (Exception exp) {
            // 记录本地异常日志
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        } finally {
            TIME_THREADLOCAL.remove();
        }
    }
}
