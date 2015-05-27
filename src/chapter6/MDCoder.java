package chapter6;

import java.security.MessageDigest;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;


/*
 * Java 仅仅支持MD2  MD5算法
 * Bouncy Castle has MD4
 */
public abstract class MDCoder {
	public static byte[] encodeMD2(byte[] data) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD2");
		return md.digest(data);
	}
	
	public static byte[] encodeMD5(byte[] data) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD5");
		return md.digest(data);
	}
	
	//P173
	public static byte[] encodeMD4(byte[] data) throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("MD4");
		
		return md.digest(data);
	}
	
	public static String encodeMD4Hex(byte[] data) throws Exception{
		byte[] bs = encodeMD4(data);
		return new String(Hex.encode(bs));
	}
	
}
