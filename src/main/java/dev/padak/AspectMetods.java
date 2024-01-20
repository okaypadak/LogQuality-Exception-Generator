package dev.padak;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectMetods {

    @Pointcut("execution(* *(..))")
    public void allMethods() {
    }

    @Before("allMethods()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before method: " + joinPoint.getSignature().getName());
    }

    @After("allMethods()")
    public void after(JoinPoint joinPoint) {
        System.out.println("After method: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* *(..))", throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println("Aspect yakaladı: Metot: " + joinPoint.getSignature().getName() + " hata fırlattı: " + exception.getMessage());
    }
}
