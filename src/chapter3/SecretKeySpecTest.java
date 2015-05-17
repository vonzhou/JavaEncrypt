package chapter3;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/*
 * P92
 */
public class SecretKeySpecTest {
	public static void main(String[] args) throws Exception{
		KeyGenerator gen = KeyGenerator.getInstance("RC2");
		SecretKey secretKey = gen.generateKey();
		byte[] kbs = secretKey.getEncoded();
		
		//通过字节数组还原秘密密钥对象
		SecretKey sks  =new SecretKeySpec(kbs, "RC2");	
	}

}
