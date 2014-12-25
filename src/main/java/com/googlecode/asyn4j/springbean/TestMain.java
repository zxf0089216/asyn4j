package com.googlecode.asyn4j.springbean;

import com.googlecode.asyn4j.core.handler.CacheAsynWorkHandler;
import com.googlecode.asyn4j.core.handler.DefaultErrorAsynWorkHandler;
import com.googlecode.asyn4j.core.handler.FileAsynServiceHandler;
import com.googlecode.asyn4j.service.AsynService;
import com.googlecode.asyn4j.service.AsynServiceImpl;

public class TestMain {
	
	public AsynService asynService;

	public void setAsynService(AsynService asynService) {
		this.asynService = asynService;
	}
	
	public void maintest(){
		for(int i=0;i<100000000;i++){
			asynService.addWork("testBean", "myName",new Object[] { "panxiuyan" + i });
			if(i%99==0){
			    System.out.println(asynService.getRunStatInfo());
			}
		}
		
		System.out.println("ok");
	}

	
	public static void main(String[] args) {
        // 初始化异步工作服务
        AsynService asynService = AsynServiceImpl.getService(300, 3000L, 100, 100,1000);
        //异步工作缓冲处理器
        asynService.setWorkQueueFullHandler(new CacheAsynWorkHandler(100));
        //服务启动和关闭处理器
        asynService.setServiceHandler(new FileAsynServiceHandler("D:/IDE/Eclipse3.7_Common/workspaces/asyn4j/asyn4j.data"));
        //异步工作执行异常处理器
        asynService.setErrorAsynWorkHandler(new DefaultErrorAsynWorkHandler());
        // 启动服务
        asynService.init();
        // 异步回调对象
        for (int i = 0; i < 1000000000; i++) {
                // 添加加异步工作- TargetService 的 test 方法 ，方法参数 asynej+ i
                asynService.addWork(TargetService.class, "test", new Object[] { "asyn4j" + i }, new TargetBack());
                //实例化目标对象再调用
               // TargetService targetService = new TargetService ();
               //asynService.addWork(
        //              targetService , "test",new Object[] { "asyn4j" + i }, new TargetBack());
               
        }
}
}
