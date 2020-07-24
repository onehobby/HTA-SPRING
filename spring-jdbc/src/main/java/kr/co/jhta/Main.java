package kr.co.jhta;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import kr.co.jhta.dao.UserDao;
import kr.co.jhta.dao.UserDaoSpringJdbcImpl;
import kr.co.jhta.vo.User;

public class Main {
	
	public static void main(String[] args) {
		
		String conf = "classpath:/spring/context.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(conf);
		UserDao userDao = ctx.getBean(UserDao.class);
		
		Scanner scanner = new Scanner(System.in);
		
		try {
		
			while(true) {
			
				System.out.println("[사용자 관리]");
				System.out.println("1.전체조회 2.조회(아이디) 3.조회(이름) 4.등록 5.삭제(아이디) 6.전체삭제 0.종료");
				System.out.println("-------------------------------------------------------------------");
				
				System.out.println("메뉴 선택>");
				int menuNo = scanner.nextInt();
				
				if (menuNo == 1) {
					System.out.println("[전체 조회]");
					
					List<User> users = userDao.getAllUsers();
					
					for (User user : users) {
						System.out.println(user.getId());
					}
					
				} else if (menuNo == 2) {
					System.out.println("[아이디로 조회]");
					
				} else if (menuNo == 3) {
					System.out.println("[이름으로 조회]");
					
				} else if (menuNo == 4) {
					System.out.println("[신규 사용자 등록 조회]");
					
					User user = new User();
					
					System.out.print("아이디를 입력하세요");
					user.setId(scanner.next());
					System.out.print("비밀번호를 입력하세요");
					user.setPassword(scanner.next());
					System.out.print("이름 입력하세요");
					user.setName(scanner.next());
					System.out.print("이메일 입력하세요");
					user.setEmail(scanner.next());
					
					userDao.insertUser(user);
					System.out.println("[사용자 등록 완료]");
					System.out.println();
					
				} else if (menuNo == 5) {
					System.out.println("[아이디로 삭제]");
					
				} else if (menuNo == 6) {
					System.out.println("[전체 삭제]");
					
				} else if (menuNo == 0) {
					ctx.destroy();
					System.out.println("*** 프로그램 종료 ***");
					return;
				}	
			}
		
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
	}

}
