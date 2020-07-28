package kr.co.jhta.dao;

import java.util.List;

import kr.co.jhta.vo.User;

public interface UserDao {
	
	/**
	 * 지정된 아이디에 해당하는 사용자정보를 반환한다.
	 * @param userId 조회할 사용자 아이디
	 * @return 사용자정보가 포함된 User객체, null 반환될 수 있음.
	 */
	User getUserById(String userId);
	
	/**
	 * 전달받은 이름에 해당하는 사용자정보를 조회한다.
	 * @param name 조회할 사용자의 이름
	 * @return 사용자정보들이 포함된 User객체 List, 조회결과가 없으면 size가 0인 List가 반환됨
	 */
	List<User> getUserByName(String name);
	
	/**
	 * 지정된 사용자 정보를 저장한다.
	 * @param user 사용자 정보가 포함된 User객체
	 */
	void insertUser(User user);
	
	/**
	 * 지정된 사용자정보를 삭제한다.
	 * @param id 삭제할 사용자의 아이디
	 */
	void deleteUser(String id);
	
	
	/**
	 * 사용자 아이디를 확인해서 해당 사용자의 정보를 업데이트한다.
	 * @param user 업데이트시킬 사용자의 정보
	 */
	void updateUser(User user);
	
	
	
}
