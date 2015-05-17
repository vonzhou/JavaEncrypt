package chapter4;

import org.apache.commons.codec.binary.Base64;


/*
 * P134
 */
public class UrlBase64Encoding2 {
	public static void main(String[] args) {
		String str = "世界你好！";
		System.err.println(str);
		byte[] input = str.getBytes();
		
		// commons codec的实现没有进行补位...
		byte[] data = Base64.encodeBase64URLSafe(input);
		System.err.println(new String(data));
		
		byte[] decode = Base64.decodeBase64(data);
		System.err.println(new String(decode));
		
	}

}
