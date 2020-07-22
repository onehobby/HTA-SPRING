package kr.co.jhta.di.service.step8;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		// String conf = "kr/co/jhta/di/service/step8/context-step8-set.xml";
		String conf = "kr/co/jhta/di/service/step8/context-step8-map.xml";
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(conf);
		
		NoticeService noticeService = ctx.getBean("noticeServiceUsingMap", NoticeService.class);
		
		noticeService.notice("관리부", "8월17일 임시공휴일 안내", "사내게시판을 확인바랍니다");
		
		ctx.destroy();
		
	}

}
