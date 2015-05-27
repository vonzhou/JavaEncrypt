package chapter6;

import org.bouncycastle.util.encoders.Hex;

public class MACCoderTest {
	public static void main(String[] args) throws Exception{
		String str = "Amusing Ourselves to Death";
		
		byte[] key = MACCoder.initHmacMD5Key();
		byte[] data = MACCoder.encodeHmacMD5(str.getBytes(), key);
		
		System.err.println(new String(Hex.encode(data)));
		
		
		byte[] key2 = MACCoder.initHmacMD2Key();
		String out = MACCoder.encodeHmacMD2Hex(str.getBytes(), key2);
		System.err.println(out);
	}

}
