package kr.co.jhta.step1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.jhta.sender.KakaotalkMessageSender;
import kr.co.jhta.sender.MessageSender;
import kr.co.jhta.service.EventService;
import kr.co.jhta.service.EventServiceImpl;

// javaConfig > xml을 이용하지 않고 spring에 bean을 등록할 수 있는 방법
// @Configuration 어노테이션을 등록해놓으면 클래스의 bean을 찾아서 Spring의 bean으로 등록해준다.
// 이러한 클래스를 bean설정 자바클래스라고 부른다.
@Configuration
public class JavaConfig {
	
	/* 아래의 spring bean configuration 파일(xml파일)의 설정과 동일설정으로
	 * 자바코드로 정의한 것이다.
	 * <bean id="kakao" class="kr.co.jhta.sender.KakaotalkMessageSender" />와 같은 형식
	 */
	
	@Bean
	public MessageSender messageSender() {
		return new KakaotalkMessageSender();
	}
	
	
	/*
	 * <bean id="eventService" class="kr.co.jhta.service.EventServiceImpl">
	 * 		<property name="messageSender" ref="messageSender" />
	 * </bean>
	 */
	@Bean
	public EventService eventService(MessageSender messageSender) {
		EventServiceImpl eventServiceImpl = new EventServiceImpl();
		eventServiceImpl.setMessageSender(messageSender);
		return eventServiceImpl;
	}

}
