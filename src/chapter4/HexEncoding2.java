package chapter4;

import org.apache.commons.codec.binary.Hex;


/*
 * P138
 */
public class HexEncoding2 {
	public static void main(String[] args) throws Exception {
		String str = " ¿ΩÁƒ„∫√£°";
		System.err.println(str);
		byte[] input = str.getBytes();
		
		String data = Hex.encodeHexString(input);
		System.err.println(data);
		
		byte[] decode = Hex.decodeHex(data.toCharArray());
		System.err.println(new String(decode));
		
	}

}
