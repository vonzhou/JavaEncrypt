package chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

public class Base64Coder2Test {

	@Test
	public void test() throws Exception{
		String input = "VONZHOU你好,沉默的大多数人";
		System.err.println("Oringin:" + input);
		
		String code = Base64Coder2.encode(input);
		System.err.println("Encoded:" + code);
		
		String output = Base64Coder2.decode(code);
		System.err.println("Decoded:" + output);
		
		assertEquals(input, output);
	}
	
	@Test
	public void testSafe() throws Exception{
		String input = "VONZHOU你好,沉默的大多数人,一个陌生女人的来信,动物庄园,活着-余华,相约星期二";
		System.err.println("Oringin:" + input);
		
		String code = Base64Coder2.encodeSafe(input);
		System.err.println("Encoded:" + code);
		
		String output = Base64Coder2.decode(code);
		System.err.println("Decoded:" + output);
		
		assertEquals(input, output);
	}

}
