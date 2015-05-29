package javaencryptart.chapter6;

import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.Security;

/*
 * P185
 * ʹ��Commons Codec���
 */
public class SHACoder2 {
	public static byte[] encodeSHA(byte[] data) throws Exception{
		//return DigestUtils.sha(data);  // ����Ѿ����Ƽ�ʹ��
		return DigestUtils.sha1(data);
	}
	
	public static String encodeSHAHex(byte[] data) throws Exception{
		return DigestUtils.sha1Hex(data);
	}

	//ͬ�� SHA-256 ,384, 512 ���ṩ��������API
	
}
