package javaencryptart.chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

public class Base64CoderTest {

	@Test
	public void test() throws Exception{
		String input = "VONZHOU你好,沉默的大多数人";
		System.err.println("Oringin:" + input);
		
		String code = Base64Coder.encode(input);
		System.err.println("Encoded:" + code);
		
		String output = Base64Coder.decode(code);
		System.err.println("Decoded:" + output);
		
		assertEquals(input, output);
	}

}
