package chapter6;

import java.security.Security;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;


// HMAC的计算都是分两步 : 密钥 - 摘要构建
public class MACCoder {
	public static byte[] initHmacMD5Key() throws Exception{
		KeyGenerator gen = KeyGenerator.getInstance("HmacMD5");
		SecretKey key = gen.generateKey();
		// 返回密钥
		return key.getEncoded();
	}
	
	public static byte[] encodeHmacMD5(byte[] data, byte[] key) throws Exception{
		// 还原密钥
		SecretKey secretKey = new SecretKeySpec(key, "HmacMD5");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		
		mac.init(secretKey);
		return mac.doFinal(data);
	}
	
	/*
	 * HmacSHA1 HmacSHA256 HmacSHA384 HmacSHA512 都可以类似实现
	 * 
	 * Bouncy Castle 提供了HmacMD2 HmacMD4 HmacSHA224 的实现 方法如下
	 */
	public static byte[] initHmacMD2Key() throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator gen = KeyGenerator.getInstance("HmacMD5");
		SecretKey key = gen.generateKey();
		// 返回密钥
		return key.getEncoded();
	}
	
	public static byte[] encodeHmacMD2(byte[] data, byte[] key) throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		// 还原密钥
		SecretKey secretKey = new SecretKeySpec(key, "HmacMD5");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		
		mac.init(secretKey);
		return mac.doFinal(data);
	}
	
	public static String encodeHmacMD2Hex(byte[] data, byte[] key) throws Exception{
		byte[] b = encodeHmacMD2(data, key);
		return new String(Hex.encode(b));
	}

}
