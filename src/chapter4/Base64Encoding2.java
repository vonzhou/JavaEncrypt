package chapter4;

import org.apache.commons.codec.binary.Base64;


/*
 * P134
 */
public class Base64Encoding2 {
	public static void main(String[] args) {
		String str = " ¿ΩÁƒ„∫√£°";
		System.err.println(str);
		byte[] input = str.getBytes();
		
		byte[] data = Base64.encodeBase64(input);
		System.err.println(new String(data));
		
		byte[] decode = Base64.decodeBase64(data);
		System.err.println(new String(decode));
		
	}

}
