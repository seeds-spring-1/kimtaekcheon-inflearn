package com.seed.spring.inflearnstudy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
    // 패키지 단위로 적용?
    // 프록시 패턴을 통해 실행하려는 함수?클래스?를 감싸게 된다.
    @Around("execution(* com.seed.spring.inflearnstudy..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Start : " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("End   : " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
