package kr.co.jhta.di.service.step7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		String conf = "kr/co/jhta/di/service/step7/context-step7.xml";
		
		 ApplicationContext ctx = new GenericXmlApplicationContext(conf);
		 
		 EventNotificationService eventNotificationService = ctx.getBean("eventNotificationServiceImpl", EventNotificationService.class);
		 
		 eventNotificationService.noticeEvent("관리", "8월 이벤트", "스포츠브랜드 10% 할인");
		
	}

}
