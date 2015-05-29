package javaencryptart.chapter4;

import org.bouncycastle.util.encoders.UrlBase64;

/*
 * P127
 * http://en.wikipedia.org/wiki/Base64
 */
public class UrlBase64Encoding {
	public static void main(String[] args) {
		String str = " ¿ΩÁƒ„∫√£°";
		System.err.println(str);
		byte[] input = str.getBytes();
		
		byte[] data = UrlBase64.encode(input);
		System.err.println(new String(data));
		
		byte[] decode = UrlBase64.decode(data);
		System.err.println(new String(decode));
		
	}

}
