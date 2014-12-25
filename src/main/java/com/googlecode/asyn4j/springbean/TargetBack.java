package com.googlecode.asyn4j.springbean;

import com.googlecode.asyn4j.core.callback.AsynCallBack;

//回调需继承AsynCallBack抽象类
public class TargetBack extends AsynCallBack {

      @Override
      public void doNotify() {
    	  Boolean result = (Boolean) methodResult;
    	  
              //输出异步方法调用结果
              System.out.println(result);
      }
      
      
      
}