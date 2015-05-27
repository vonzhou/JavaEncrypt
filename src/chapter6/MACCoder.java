package chapter6;

import java.security.Security;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;


// HMAC�ļ��㶼�Ƿ����� : ��Կ - ժҪ����
public class MACCoder {
	public static byte[] initHmacMD5Key() throws Exception{
		KeyGenerator gen = KeyGenerator.getInstance("HmacMD5");
		SecretKey key = gen.generateKey();
		// ������Կ
		return key.getEncoded();
	}
	
	public static byte[] encodeHmacMD5(byte[] data, byte[] key) throws Exception{
		// ��ԭ��Կ
		SecretKey secretKey = new SecretKeySpec(key, "HmacMD5");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		
		mac.init(secretKey);
		return mac.doFinal(data);
	}
	
	/*
	 * HmacSHA1 HmacSHA256 HmacSHA384 HmacSHA512 ����������ʵ��
	 * 
	 * Bouncy Castle �ṩ��HmacMD2 HmacMD4 HmacSHA224 ��ʵ�� ��������
	 */
	public static byte[] initHmacMD2Key() throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator gen = KeyGenerator.getInstance("HmacMD5");
		SecretKey key = gen.generateKey();
		// ������Կ
		return key.getEncoded();
	}
	
	public static byte[] encodeHmacMD2(byte[] data, byte[] key) throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		// ��ԭ��Կ
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
