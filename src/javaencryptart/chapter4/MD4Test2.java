package javaencryptart.chapter4;

import java.security.MessageDigest;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
/* 
 * Bouncy Castle 
 */
public class MD4Test2 {
	public static byte[] encodeMD4(byte[]  data) throws Exception{
		
		Security.addProvider(new BouncyCastleProvider()); //
		
		MessageDigest md = MessageDigest.getInstance("MD4");
		md.update(data);
		return md.digest();
	}
	
	public static void main(String[] args) throws Exception{
		byte[] input = "vonzhou".getBytes();
		byte[] output = encodeMD4(input);
		
	}

}
