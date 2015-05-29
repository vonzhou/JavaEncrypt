package javaencryptart.chapter6;

import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.Security;

/*
 * P185
 * 使用Commons Codec组件
 */
public class SHACoder2 {
	public static byte[] encodeSHA(byte[] data) throws Exception{
		//return DigestUtils.sha(data);  // 这个已经不推荐使用
		return DigestUtils.sha1(data);
	}
	
	public static String encodeSHAHex(byte[] data) throws Exception{
		return DigestUtils.sha1Hex(data);
	}

	//同样 SHA-256 ,384, 512 都提供了这样的API
	
}
