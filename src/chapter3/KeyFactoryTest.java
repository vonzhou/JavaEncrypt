package chapter3;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.PKCS8EncodedKeySpec;


/*
 * //P60
 * http://en.wikipedia.org/wiki/PKCS
 */
public class KeyFactoryTest {
	public static void main(String[] args) throws Exception{
		KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
		gen.initialize(1024);
		KeyPair keyPair = gen.genKeyPair();
		byte[] keyBytes = keyPair.getPrivate().getEncoded();
		
		// ªÒµ√√‹‘øπÊ∑∂
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		
		//
		Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
		System.out.println(privateKey.getFormat());
	}

}
