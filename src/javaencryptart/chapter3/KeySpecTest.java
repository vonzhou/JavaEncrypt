package javaencryptart.chapter3;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/*
 * P90
 */
public class KeySpecTest {
	public static void main(String[] args) throws Exception{
		KeyPairGenerator gen = KeyPairGenerator.getInstance("DSA");
		gen.initialize(1024);
		KeyPair keys = gen.genKeyPair();
		byte[] publicbs = keys.getPublic().getEncoded();
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicbs);
		//再转为公钥对象
		KeyFactory fact = KeyFactory.getInstance("DSA");
		PublicKey pub = fact.generatePublic(keySpec);
		
		//------------私钥的处理和上面类似-----------------//
		byte[] privatebs = keys.getPrivate().getEncoded();
		PKCS8EncodedKeySpec keySpec2 = new PKCS8EncodedKeySpec(privatebs);
		KeyFactory fact2 = KeyFactory.getInstance("DSA");
		PrivateKey pri = fact2.generatePrivate(keySpec2);
	}

}
