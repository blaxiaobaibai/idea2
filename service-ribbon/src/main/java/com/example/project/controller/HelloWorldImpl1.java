package com.example.project.controller;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldImpl1 implements HelloWorld{
    private  int a;

    @Override
    public String printHelloWorld(String name,int id) {
        try {
            int i=1/0;
        }catch (Exception e){
            System.out.println("这是一场");
        }
        String s = null;
       // System.out.println(s.substring(0,3));
        System.out.println("********** HelloWorldImpl1.printHelloWorld()"+"参数name:"+name+"参数id"+id);
        return name+id;
        }

    @Override
    public String doPrint(String name,int id) {
        System.out.println("********* HelloWorldImpl11111111.doPrint()"+"参数name:"+name+"参数id"+id);
        return name+id;
    }

}
