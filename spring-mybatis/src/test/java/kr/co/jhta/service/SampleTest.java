package kr.co.jhta.service;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class SampleTest {
	
	@Test
	public void testPlus1() {
		Sample sample = new Sample();
		int value = sample.plus(10, 30);
		assertEquals(40, value);		// 단언문, assertEquals(결과가 예상되는값, 대입할 값);
	}
	
	@Ignore								// testcase에서 제외시킬 단위테스트구문에 부착하는 annotation
	@Test
	public void testPlus2() {
		Sample sample = new Sample();
		int value = sample.minus(10, 30);
		assertEquals(-20, value);		// 단언문, assertEquals(결과가 예상되는값, 대입할 값);
	}
}
