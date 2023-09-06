package balachonov.aspects;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static balachonov.util.Constants.*;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.EMPTY;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Pointcut("execution(* balachonov.controllers..*(..)) " +
            "&& !@annotation(balachonov.aspects.anotations.SkipLog)")
    private void getControllersPointcut() {
    }

    @Pointcut("execution(* balachonov.services.impl.EmailServiceImpl.*(..)) " +
            "&& !@annotation(balachonov.aspects.anotations.SkipLog)")
    private void getEmailServicePointcut() {
    }

    @Before("getControllersPointcut()")
    private void logRequest(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info(REQUEST_LOGGER_PATTERN,
                request.getMethod(),
                request.getRequestURI(),
                joinPoint.getSignature().toShortString(),
                joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "getControllersPointcut()", returning = "response")
    private void logResponse(JoinPoint joinPoint, Object response) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info(RESPONSE_LOGGER_PATTERN,
                request.getMethod(),
                request.getRequestURI(),
                joinPoint.getSignature().toShortString(),
                ofNullable(response).orElse(EMPTY));
    }

    @After("getEmailServicePointcut()")
    private void logEmailSend(JoinPoint joinPoint) {
        log.info(MAIL_SEND_LOGGER_PATTERN,
                joinPoint.getSignature().toShortString(),
                joinPoint.getArgs());
    }
}