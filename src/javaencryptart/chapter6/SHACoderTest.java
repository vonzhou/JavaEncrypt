package javaencryptart.chapter6;

import org.bouncycastle.util.Arrays;

public class SHACoderTest {
	/*
	 * ��ϢժҪ�㷨����Ҫ�ص��Ƕ�ͬһ��������
	 */
	public static void main(String[] args) throws Exception{
		String str = "Password";
		byte[] out1 = SHACoder.encodeSHA(str.getBytes());
		byte[] out2 = SHACoder.encodeSHA(str.getBytes());
		
		System.out.println(Arrays.areEqual(out1, out2));// true
		
		String hex1 = SHACoder.encodeSHA224Hex(str.getBytes());
		String hex2 = SHACoder.encodeSHA224Hex(str.getBytes());
		System.out.println(hex1);
		System.out.println(hex2);
	}

}
