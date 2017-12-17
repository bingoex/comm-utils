package com.bingo.comm.demo;

/**
 * 日志详情跟踪记录，用于开发测试、问题排查
 */
/*
import com.xxx.common.convert.Convert;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TraceLogAspect {

    @Pointcut("execution(* com.xxx.fortress.ds.impl.*.*(..))")
    public void dataSource() {
    }

    @Pointcut("execution(* com.xxx.fortress.xxx.impl.*.*(..))")
    public void aaa() {
    }

    @Pointcut("execution(* com.xxx.fortress.remote.*.*(..))")
    public void remote() {
    }


    @Around("dataSource() || aaa() || remote()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long userId = Convert.asLong(EagleEye.getAttribute("userId"));
        long pageId = Convert.asLong(EagleEye.getAttribute("pageId"));
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object result = null;
        Exception exp = null;
        try {
            result = joinPoint.proceed();
            return result;
        } catch (Exception e) {
            PgLog.exp(e, className, methodName, pageId, userId, JSON.toJSONString(args));
            exp = e;
            throw e;
        } finally {
            if (needLog(userId, pageId)) {
                PgLog.trace(LogLevel.INFO, exp, className, methodName, pageId, userId,
                        JSON.toJSONString(args), JSON.toJSONString(result));
            }
        }

    }

    private boolean needLog(long userId, long pageId) {
        return true;
    }


}
*/
