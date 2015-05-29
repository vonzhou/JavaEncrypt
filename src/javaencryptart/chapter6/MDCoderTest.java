package javaencryptart.chapter6;

import org.bouncycastle.util.Arrays;

public class MDCoderTest {
	/*
	 * ��ϢժҪ�㷨����Ҫ�ص��Ƕ�ͬһ��������
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
