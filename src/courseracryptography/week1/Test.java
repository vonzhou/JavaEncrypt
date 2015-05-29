package courseracryptography.week1;

import org.apache.commons.codec.binary.Hex;

public class Test {
	public static void main(String[] args) {
		String s = "ab";
		byte[] bs = s.getBytes();
		System.out.println(Hex.encodeHex(bs));
		s = "ÄãºÃ";
		bs = s.getBytes();
		System.out.println(Hex.encodeHex(bs));
	}

}
