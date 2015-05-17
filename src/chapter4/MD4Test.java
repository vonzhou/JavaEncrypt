package chapter4;

import java.security.MessageDigest;
/* Java8默认不支持 MD4
 *  java.security.NoSuchAlgorithmException: MD4 MessageDigest not available
 */
public class MD4Test {
	public static byte[] encodeMD4(byte[]  data) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD4");
		md.update(data);
		return md.digest();
	}
	
	public static void main(String[] args) throws Exception{
		byte[] input = "vonzhou".getBytes();
		byte[] output = encodeMD4(input);
		
	}

}
