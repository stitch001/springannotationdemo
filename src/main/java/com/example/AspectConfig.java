package com.example;

import java.util.Date;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {
    @Before("execution(* com.example.Student.*(..))")
    public void beforeExeMethod(){
        System.out.println("目标方法之前执行：" + new Date());
    }

    @Before("execution(* com.example.UserService.*(..))")
    public void beforeExeUserService(){
        System.out.println("User service 目标方法之前执行：" + new Date());
    }

    @AfterReturning(value = "execution(* com.example.UserService.GetUser(..))",returning = "retVal")
    public void AfterReturningTest(Object retVal){
        System.out.println("After 返回后执行" + retVal.toString());
    }

    // @Pointcut("execution(* com.example.UserService.*(..))")
    // public void businessService() {}
}
