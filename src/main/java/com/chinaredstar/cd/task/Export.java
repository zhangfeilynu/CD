package com.chinaredstar.cd.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Export {

	@Scheduled(cron = "0 0/1 * * * ?")
	public void minuteExport() {
		log.debug("每分钟执行一次的任务：" + getDate());
		System.out.println("每分钟");

	}

	@Scheduled(fixedRate = 5000)
	public void fiveSecondExport() {
		log.debug("每5秒执行一次：" + getDate());
		System.out.println("5秒");
	}

	@Scheduled(cron = "0/2 * * * * ?")
	public void twoSecondExport() {
		log.debug("每2秒执行一次：" + getDate());
		System.out.println("2秒");
	}

	@Scheduled(cron = "0 55 14 ? * *")
	public void regularTimeExport() {
		log.debug("每天上午14点55分执行：" + getDate());
		System.out.println("每天上午14点55分执行");
	}

	private String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

}
