package com.bingo.comm.demo;

/**
 * demo for Aspect
 */
/*
@Aspect
@Component
public class PgCheckAspect {

    @Pointcut("execution(* com.perceptor.check..*.*(..))")
    public void executeCheck() {
    }

    @Around("executeCheck()")
    public Object doCheck(ProceedingJoinPoint joinPoint) {
        String classMethod = getName(joinPoint);
        Object args[] = joinPoint.getArgs();

        CheckResult result = null;

        try {
            //执行检查
            result = (CheckResult)joinPoint.proceed();

        } catch (Throwable e) {
            result = CheckResult.exception(RuleResultCode.RULE_EXECUTE_EXCEPTION);
            PgLog.exp(e,
                    RuleContext.getScene(),
                    EagleEye.getTraceId(),
                    RuleContext.getId(),
                    RuleContext.getOrder(),
                    classMethod,
                    result.getSuccess(),
                    result.isException(),
                    result.getCode(),
                    result.getMessage(),
                    JSON.toJSONString(args));
        } finally {
            //返回结果不能为空
            if (result == null) {
                result = CheckResult.exception(RuleResultCode.RULE_RETURN_NULL);
            }

            PgLog.rule(
                    RuleContext.getScene(),
                    EagleEye.getTraceId(),
                    RuleContext.getId(),
                    RuleContext.getOrder(),
                    classMethod,
                    result.getSuccess(),
                    result.isException(),
                    result.getCode(),
                    result.getMessage(),
                    JSON.toJSONString(args));
        }

        return result;
    }

    private String getName(ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        return className.substring(className.lastIndexOf(".") + 1) + "." + methodName;
    }

}
*/
