package kr.co.jhta.di.service;

public class SmsMessageSender implements MessageSender {
	
	// 값을 주입받기 위한 필드와 setter메소드가 필요하다
	
	private String telecom;
	
	public void setTelecom(String telecom) {
		this.telecom = telecom;
	}
	
	@Override
	public void send(String from, String to, String subject, String content) {
		
		System.out.println(telecom + " 통신사를 이용합니다.");
		System.out.println("SMS 발신자: " + from);
		System.out.println("SMS 수신자: " + to);
		System.out.println("SMS 제  목: " + subject);
		System.out.println("SMS 내  용: " + content);
		System.out.println("-------------------");
		
	}

	
}
