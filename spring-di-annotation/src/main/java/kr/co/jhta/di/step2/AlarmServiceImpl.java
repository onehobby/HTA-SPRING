package kr.co.jhta.di.step2;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.jhta.di.MessageSender;

@Service
public class AlarmServiceImpl implements AlarmService {
	
	/*
		@Autowired
			* 빈(bean) 자동 주입을 지원하는 어노테이션이다.
			* 멤버변수, setter메소드, 생성자에 부착할 수 있다.
			* 해당 annotation이 부착된 대상의 타입을 확인해서
			  - 멤버변수에 부차갛면 변수의 타입(가장많이 쓰임)
			  - setter에 부착하면 매개변수의 타입
			  - 생성자에 부착하면 매개변수의 타입
			  Spring Container에서 해당 타입의 객체(구현객체 혹은 자식객체)를
			   찾아서 부착대상에게 자동으로 의존성주입 작업을 수행한다.
			* Spring Container에 동일한 타입의 객체가 2개 이상이거나
			  존재하지 않으면 에러를 발생시킨다
			* 타입을 기준으로 의존성 주입 작업을 수행한다.(구현객체 혹은 자식객체)
		 
		@Resource
			* @Autowired의 기능을 전부 지원한다.
			* @Resource(name="빈의 이름")의 형식으로 사용하면		=> 객체의 이름은 @Component("객체의이름")형식으로 명명
		 	  Spring Container에서 동일한 이름을 가진 객체를 찾아서
		 	   의존성 주입작업을 수행한다.
		 	
		 	****** 1번 형식을 선호함 ******
		 	1. @Resource(name="kakao")
		 	  private MessageSender messageSender;
		 	  	- Spring Container안에서 MessageSender타입의 객체 중
		 	  	   빈(bean)의 이름이 "kakao"인 객체를 찾아서 의존성주입(변수안에 대입)을 실행한다.
		 	  	   
		 	2. @Resource
		 	  private MessageSender sms;
		 	    - Spring Container안에서 MessageSender 타입의 객체를 찾는다.
		 	    - 객체가 하나만 존재하면 해당 객체로 의존성 주입을 실행한다.
		 	    - 객체가 2개이상 존재하면 빈(bean)의 이름이 "sms"인 객체로
		               의존성주입(변수안에 대입)을 실행한다.
		        - @Resource는 타입과 이름을 사용해서 의존성 주입을 실행한다.
		               
		      
	*/
	

	@Resource
	// messageSender인터페이스를 구현한 객체가 여러개 일때 특정클래스를 지정하지않으면 오류가난다.
	
	private MessageSender kakao;
	
	@Override
	public void alarm(String message) {
		
		kakao.send("민방위본부", "전국민", "비상사태", message);
		
	}

}
