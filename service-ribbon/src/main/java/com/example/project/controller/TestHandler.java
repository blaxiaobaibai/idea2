package com.example.project.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;



import java.util.Arrays;

/*@Aspect()
@Component*/
public class TestHandler {
    @Around("execution(* com.example.project.controller.HelloWorldImpl1.printHelloWorld*(..))")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        System.out.println("@Around：执行目标方法之前...");
        //访问目标方法的参数：
        Object[] args = point.getArgs();
        if (args != null && args.length > 0 && args[0].getClass() == String.class) {
            args[0] = "改变后的参数1";
        }
        //用改变后的参数执行目标方法
        Object returnValue = point.proceed(args);
        System.out.println("@Around：执行目标方法之后...");
        System.out.println("@Around：被织入的目标对象为：" + point.getTarget());
        System.out.println("@Around：返回结果：" + returnValue);
        return "原返回值：" + returnValue + "，这是返回结果的后缀";
    }
    @Before("execution(* com.example.project.controller.*.*(..))")
    public void beforeMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        System.out.println("【Test测试白】the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
    }

    /**
     * 返回通知：目标方法正常执行完毕时执行以下代码
     * @param jp
     * @param result
     */
    @AfterReturning(value="execution(* com.example.project.controller.*.*(..))",returning="result")
    public void afterReturningMethod(JoinPoint jp, Object result){
        String methodName = jp.getSignature().getName();
        System.out.println("【返回通知】the method 【" + methodName + "】 ends with 【" + result + "】"+"["+Arrays.asList(jp.getArgs())+"]");
    }

    /**
     * 后置通知：目标方法执行之后执行以下方法体的内容，不管是否发生异常。
     * @param jp
     */
    @After("execution(* com.example.project.controller.*.*(..))")
    public void afterMethod(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        System.out.println("【后置通知】this is a afterMethod advice..."+methodName+"|||"+ Arrays.asList(jp.getArgs()));
    }

    /**
     * 异常通知：目标方法发生异常的时候执行以下代码
     */
    @AfterThrowing(value="execution(* com.example.project.controller.*.*(..))",throwing="e")
    public void afterThorwingMethod(JoinPoint jp, NullPointerException e){
        String methodName = jp.getSignature().getName();
        System.out.println("【异常通知】the method 【" + methodName + "】 occurs exception: " + e);
    }

//  /**
//   * 环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
//   * @return
//   */
//  @Around(value="execution(* com.qcc.beans.aop.*.*(..))")
//  public Object aroundMethod(ProceedingJoinPoint jp){
//      String methodName = jp.getSignature().getName();
//      Object result = null;
//      try {
//          System.out.println("【环绕通知中的--->前置通知】：the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
//          //执行目标方法
//          result = jp.proceed();
//          System.out.println("【环绕通知中的--->返回通知】：the method 【" + methodName + "】 ends with " + result);
//      } catch (Throwable e) {
//          System.out.println("【环绕通知中的--->异常通知】：the method 【" + methodName + "】 occurs exception " + e);
//      }
//
//      System.out.println("【环绕通知中的--->后置通知】：-----------------end.----------------------");
//     //返回修改后的返回值  如  result=result+"as"
// return result;
//  }
}