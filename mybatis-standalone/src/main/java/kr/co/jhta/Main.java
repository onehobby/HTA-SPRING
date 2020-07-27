package kr.co.jhta;

import java.util.List;

import kr.co.jhta.dao.UserDao;
import kr.co.jhta.vo.User;

public class Main {
	
	public static void main(String[] args) {
		
		
		UserDao userDao = new UserDao();
		/*
		System.out.println("새 사용자 등록하기");
		User user1 = new User("hong4", "홍길사", "zxcv1234", "zxcv@gmail.com");
		
		userDao.insertUser(user1);
		System.out.println("새 사용자 등록이 완료되었습니다.");
		*/
		
		
		/*
		List<User> users1 = userDao.getAllUsers();
		
		System.out.println();
		for (User user : users1) {
			System.out.println(user.getId() + ", " + user.getName());
		}
		
		System.out.println("특정 아이디의 사용자 조회하기");
		User user2 = userDao.getUserById("1");
		System.out.println(user2);
		if (user2 != null) {
			System.out.println(user2.getId() + ", " + user2.getName() + ", " + user2.getEmail());
		} else {
			System.out.println("지정된 아이디의 사용자정보가 존재하지 않습니다.");
		}
		*/
		/*
		System.out.println("전체 사용자 삭제");
		userDao.deleteAllUsers();
		*/
		
		/*
		userDao.deleteUserById("hong4");
		*/
		
		System.out.println("전체 사용자 수 조회");
		int userCount = userDao.getUserCount();
		System.out.println("전체 사용자 수: " + userCount);
		
		
		/*
		User user = userDao.getUserById("hong4");
		
		System.out.println(user.getId());
		user.setPassword("1234");
		user.setEmail("123456789");
		
		userDao.updateUser(user);
		*/
		
		List<User> users = userDao.getUsersByName("홍길사");
		
	}

}
