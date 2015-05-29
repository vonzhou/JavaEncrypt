package javaencryptart.chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

public class UrlBase64CoderTest {

	@Test
	public void test() throws Exception{
		String input = "沉默的大多数人http://www.baidu.com/?a=b";
		System.err.println("Oringin:" + input);
		
		String code = UrlBase64Coder.encode(input);
		System.err.println("Encoded:" + code);
		
		String output = UrlBase64Coder.decode(code);
		System.err.println("Decoded:" + output);
		
		assertEquals(input, output);
	}

}
