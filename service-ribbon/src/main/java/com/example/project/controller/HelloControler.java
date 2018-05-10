package com.example.project.controller;

import com.example.project.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
    /*@Autowired
    HelloService helloService;
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam("name") String name){
        return helloService.hiService(name);
    }*/
    public static void main (String[] args){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("aop.xml");

        HelloWorld hw1 = (HelloWorld)ctx.getBean("helloWorldImpl1");
        HelloWorld hw2 = (HelloWorld)ctx.getBean("helloWorldImpl2");
        hw1.printHelloWorld("lsf",1);
        System.out.println("——————————这是断点——————————————");
        //hw1.doPrint("lsf2",2);

        System.out.println();
       // hw2.printHelloWorld("lsf3",3);
        System.out.println();
        //hw2.doPrint("lsf4",4);
    }
}
