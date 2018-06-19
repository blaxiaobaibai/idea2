package com.example.project.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Aspect
@Component
public class LogHandler {
    public void LogBefore()
    {
        System.out.print("+++++++LogHandler xml设置++++++++++日志logBefore方法前");
        System.out.println("+++++++++++++++++++++++++++Log before method");
    }

    public void LogAfter(JoinPoint jp)
    {
        String methodName = jp.getSignature().getName();
        System.out.print("+++LogHandler xml设置+++++日志LogAfter方法后");
        System.out.print("++++++++++Log after method");
        //访问目标方法的参数：

            System.out.println("参数啊："+methodName+"||"+Arrays.asList(jp.getArgs()));

    }

    @Before("execution(* com.example.project.controller.*.*(..))")
    public void beforeMethod(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        System.out.println("【前置通知logHandler】the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
    }
}
