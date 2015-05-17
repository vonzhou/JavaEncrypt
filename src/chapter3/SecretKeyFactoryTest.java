package chapter3;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;


/*
 * 80
 */
public class SecretKeyFactoryTest {
	public static void main(String[] args) throws Exception{
		// DES对称加密算法密钥生成器
		KeyGenerator gen = KeyGenerator.getInstance("DES");
		//生成密钥
		SecretKey key = gen.generateKey();
		
		byte[] kbytes = key.getEncoded();
		
		//构建密钥规范对象
		DESKeySpec spec = new DESKeySpec(kbytes);
		//密钥工厂对象
		SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
		//通过密钥规范来生成秘密密钥
		SecretKey key2 = factory.generateSecret(spec);
	}

}
