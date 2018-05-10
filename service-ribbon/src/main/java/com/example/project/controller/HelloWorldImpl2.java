package com.example.project.controller;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldImpl2 implements  HelloWorld {
    @Override
    public String printHelloWorld(String name,int id) {
        System.out.println("***********Enter HelloWorldImpl22222.printHelloWorld()"+"参数name:"+name+"参数id"+id);
        return name+id;
    }

    @Override
    public String doPrint(String name,int id) {
        System.out.println("*********Enter HelloWorldImpl22222.doPrint()"+"参数name:"+name+"参数id"+id);
        return name+id;
    }
}
