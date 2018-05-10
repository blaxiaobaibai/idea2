package com.example.project.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class LController {
    public static void main(String args[]){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationAop.xml");
        HelloWorldImpl1 manager =(HelloWorldImpl1) context.getBean("helloWorldImpl1");
        HelloWorldImpl1 a = context.getBean(HelloWorldImpl1.class);
        System.out.println(a+"|||");
        manager.printHelloWorld("lsf",1);
        System.out.println(manager);
        System.out.println("___________________分割______________");
    }
}
