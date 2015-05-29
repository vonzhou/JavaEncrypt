package javaencryptart.chapter6;

import org.bouncycastle.util.Arrays;

public class MDCoderTest {
	/*
	 * 消息摘要算法的主要特点是对同一段数据做
	 */
	public static void main(String[] args) throws Exception{
		String str = "Password";
		byte[] out1 = MDCoder.encodeMD5(str.getBytes());
		byte[] out2 = MDCoder.encodeMD5(str.getBytes());
		
		System.out.println(Arrays.areEqual(out1, out2));// true
		
		String hex1 = MDCoder.encodeMD4Hex(str.getBytes());
		String hex2 = MDCoder.encodeMD4Hex(str.getBytes());
		System.out.println(hex1);
		System.out.println(hex2);
	}

}
