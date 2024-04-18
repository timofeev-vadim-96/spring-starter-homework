package ru.gb.timerstarter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.event.Level;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class TimerAspect {
    private final TimerLoggingProperties timerLoggingProperties;

    @Around("@within(Timer) || @annotation(Timer)")
    private Object measureExecutionTime(ProceedingJoinPoint joinPoint){
        try {
            long start = System.currentTimeMillis();

            Object result = joinPoint.proceed();

            long elapsedTime = System.currentTimeMillis() - start;

            log.atLevel(timerLoggingProperties.getTimerLogLevel()).log("Метод " + joinPoint.getSignature().getName() + " класса " +
                    joinPoint.getTarget().getClass().getSimpleName() + " выполнился за " + elapsedTime + " миллисекунд");

            return result;
        } catch (Throwable exception){
            throw new RuntimeException(exception);
        }
    }
}
