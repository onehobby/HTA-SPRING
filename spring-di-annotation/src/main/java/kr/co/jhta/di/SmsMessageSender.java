package kr.co.jhta.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("sms") //@Component("객체의이름")으로 형식으로 설정
public class SmsMessageSender implements MessageSender {
	
	@Value("${message.sender.sms.company}") //       => spring.properties의 설정된 값을 key:value형태로 가져온다.
											// key   => message.sender.sms.company
											// value => SKT
	private String company;
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public void send(String from, String to, String subject, String content) {
		
		System.out.println(company + " 통신사를 이용합니다.");
		System.out.println("SMS 발신자: " + from);
		System.out.println("SMS 수신자: " + to);
		System.out.println("SMS 제  목: " + subject);
		System.out.println("SMS 내  용: " + content);
		System.out.println("-------------------");
		
	}

}
