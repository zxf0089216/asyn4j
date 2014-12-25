package com.googlecode.asyn4j.springbean;

//异步调用对象
public class TargetService {
      public boolean test(String name){
              System.out.println(name +" test is execute!");
              return true;
      }

}