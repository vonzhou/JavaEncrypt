package chapter6;

import org.apache.commons.codec.digest.DigestUtils;

public class CommonsMD5 {
	public static byte[] encodeMD5(String data) throws Exception{
		return DigestUtils.md5(data);
	}
	
	public static String encodeMD5Hex(String data) throws Exception{
		return DigestUtils.md5Hex(data);
	}
	
	
	public static void main(String[] args) throws Exception{
		String str = "沉默的大多数人";
		String hex1 = encodeMD5Hex(str);
		String hex2 = encodeMD5Hex(str);
		System.out.println(hex1);
		System.out.println(hex2);
	}
	
}
