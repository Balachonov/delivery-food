package balachonov.aspects;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import static balachonov.util.Constants.EXECUTION_TIME_LOGGER_PATTERN;

@Slf4j
@Aspect
@Component
public class ExecutionTimeLoggerAspect {

    @Pointcut("@annotation(balachonov.aspects.anotations.ExecutionTimeLog)")
    private void getExecutionTimePointcut() {
    }

    @Around("getExecutionTimePointcut()")
    @SneakyThrows
    private Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long finishTime = System.currentTimeMillis();
        log.info(EXECUTION_TIME_LOGGER_PATTERN,
                proceedingJoinPoint.getSignature().toShortString(),
                finishTime - startTime);
        return result;
    }
}