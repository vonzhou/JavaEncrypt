package javaencryptart.chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

public class UrlBase64Coder2Test {

	@Test
	public void test() throws Exception{
		String input = "��Ĭ�Ĵ������http://www.baidu.com/?a=b";
		System.err.println("Oringin:" + input);
		
		String code = UrlBase64Coder2.encode(input);
		System.err.println("Encoded:" + code);
		
		String output = UrlBase64Coder2.decode(code);
		System.err.println("Decoded:" + output);
		
		assertEquals(input, output);
	}

}
