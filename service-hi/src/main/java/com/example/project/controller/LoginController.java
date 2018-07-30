package com.example.project.controller;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;

public class LoginController {
   public static void main(String [] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

       Calendar cal = Calendar.getInstance();
       cal.setTime(new Date());
       cal.add(Calendar.DATE, +2);
       int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
       System.out.println(week_index);

       String s=EncoderByMd5("123456qqq");
       System.out.println(s);
       System.out.println("dev分支2");

   }
    public static String EncoderByMd5(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        byte[] md5Bytes = md5.digest(str.getBytes("utf-8"));
        return base64en.encode(md5Bytes);
    }

}
