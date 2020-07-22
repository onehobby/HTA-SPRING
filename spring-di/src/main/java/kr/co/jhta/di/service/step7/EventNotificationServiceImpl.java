package kr.co.jhta.di.service.step7;

import java.util.List;

import kr.co.jhta.di.service.MessageSender;
import kr.co.jhta.di.vo.User;

public class EventNotificationServiceImpl implements EventNotificationService {
	
	private UserService userService;
	private MessageSender messageSender;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}
	
	// Spring Container에서 객체조립이 끝난 후 실행시킬 메소드
	@Override
	public void noticeEvent(String dept, String eventName, String eventContent) {
		
		List<User> users = userService.getAllUser();
		
		for (User user : users) {
			messageSender.send(dept, user.getName(), eventName, eventContent);
		}
		
	}

}
