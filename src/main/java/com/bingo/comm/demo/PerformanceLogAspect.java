package com.bingo.comm.demo;

public class PerformanceLogAspect {
    /*
@Component
public class DataFetcherPerformanceAspect {

    @Around("@annotation(dataFetcher)")
    public Object around(ProceedingJoinPoint joinPoint, GraphQLDataFetcher dataFetcher) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String resultCode = RPC_RESULT_SUCCESS;
        String appendMsg = "";
        long start = System.currentTimeMillis();

        try {
            XXXX.startLocal(className, methodName);
            return joinPoint.proceed();
        } catch (Exception e) {
            resultCode = RPC_RESULT_FAILED;
            appendMsg = e.getMessage();
            throw e;
        } finally {
            long cost = System.currentTimeMillis() - start;
            BizMonitor.stat("$app", methodName + ":" + dataFetcher.value(), resultCode).countAndSum(cost);
            XXXX.endLocal(resultCode, appendMsg);
        }

    }


}

     */
}
