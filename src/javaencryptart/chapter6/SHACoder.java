package javaencryptart.chapter6;

import java.security.MessageDigest;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.Security;

public class SHACoder {
	public static byte[] encodeSHA(byte[] data) throws Exception{
		MessageDigest md = MessageDigest.getInstance("SHA");
		return md.digest(data);
	}

	public static byte[] encodeSHA256(byte[] data) throws Exception{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		return md.digest(data);
	}
	
	public static byte[] encodeSHA384(byte[] data) throws Exception{
		MessageDigest md = MessageDigest.getInstance("SHA-384");
		return md.digest(data);
	}
	
	public static byte[] encodeSHA512(byte[] data) throws Exception{
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		return md.digest(data);
	}
	
	/*
	 * Bouncy Castle 提供了SHA224的支持
	 */
	public static byte[] encodeSHA224(byte[] data) throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("SHA-224");
		return md.digest(data);
	}
	public static String encodeSHA224Hex(byte[] data) throws Exception{
		byte[] b =  encodeSHA224(data);
		return new String(Hex.encode(b));
	}
	
}
