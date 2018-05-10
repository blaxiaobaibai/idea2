package com.example.project.controller;

public class TimeHandler {
    public void printTime()
    {
        System.out.print("------------222222后 横切关注点，这里是打印时间：");
        System.out.println("CurrentTime = " + System.currentTimeMillis());
    }
    public void printTime2()
    {
        System.out.print("------------1111111前 横切关注点，这里是打印时间：");
        System.out.println("CurrentTime = " + System.currentTimeMillis());
    }
}
