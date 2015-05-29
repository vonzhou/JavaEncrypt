package javaencryptart.chapter4;

import org.bouncycastle.util.encoders.Hex;

/*
 * P130
 */
public class HexEncoding {
	public static void main(String[] args) {
		String str = " ¿ΩÁƒ„∫√£°";
		System.err.println(str);
		byte[] input = str.getBytes();
		
		byte[] data = Hex.encode(input);
		System.err.println(new String(data));
		
		byte[] decode = Hex.decode(data);
		System.err.println(new String(decode));
		
	}

}
