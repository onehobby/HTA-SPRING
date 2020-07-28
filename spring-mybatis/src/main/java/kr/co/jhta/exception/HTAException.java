package kr.co.jhta.exception;

/**
 * spring-mybatis 프로젝트에서 사용되는 예외객체다.
 * RuntimeException류의 Exception은 예외를 핸들링할필요가없다
 * @author JHTA
 *
 */
public class HTAException extends RuntimeException {
	
	public HTAException(String message) {
		super(message);
	}
	
	public HTAException(String message, Throwable cause) {
		super(message, cause);
	}
	
	

}
