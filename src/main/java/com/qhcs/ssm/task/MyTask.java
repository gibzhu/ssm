package com.qhcs.ssm.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * 定时任务测试类
 * 
 * @version 2017年6月5日上午11:16:10
 * @author zhuwenbin
 */
@Component
public class MyTask {

	/**
	 * 
	 * xml配置的方式运行定时任务
	 * 
	 * @version 2017年6月5日上午11:53:09
	 * @author zhuwenbin
	 */
	public void runTask() {
		System.out.println("正在执行runTask()定时任务");
	}

	/**
	 * 
	 * 注解的方式运行定时任务
	 * 
	 * @version 2017年6月5日上午11:52:53
	 * @author zhuwenbin
	 */
	@Scheduled(cron = "0/10 * * * * ?")
	public void runTask2() {
		System.out.println("正在执行runTask2()定时任务");
	}
}
