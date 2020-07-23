package kr.co.jhta.di.step1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.co.jhta.di.SmsMessageSender;

public class Main {
	
	public static void main(String[] args) {
		
		String conf = "classpath:/spring/context-step1.xml";
		
		ApplicationContext ctx = new GenericXmlApplicationContext(conf);
		
		SmsMessageSender sender = ctx.getBean(SmsMessageSender.class);
		EventNotificationServiceImpl eventNotificationServiceImpl = ctx.getBean(EventNotificationServiceImpl.class);
		
		System.out.println(sender);
		
		sender.send("홍보부", "010-1111-1111", "창고대방출", "전품목 50%할인");
		
		eventNotificationServiceImpl.notice("홍보부", "폐업안내", "그동안 감사했습니다.");
		
	}

}
