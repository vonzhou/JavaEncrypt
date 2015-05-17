package chapter4;

import org.bouncycastle.util.encoders.Base64;

/*
 * P127
 * http://en.wikipedia.org/wiki/Base64
 */
public class Base64Encoding {
	public static void main(String[] args) {
		String str = " ¿ΩÁƒ„∫√£°";
		System.err.println(str);
		byte[] input = str.getBytes();
		
		byte[] data = Base64.encode(input);
		System.err.println(new String(data));
		
		byte[] decode = Base64.decode(data);
		System.err.println(new String(decode));
		
	}

}
