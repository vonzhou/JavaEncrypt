package javaencryptart.chapter3;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

/*
 * P64
 */
public class SignatureTest {
	public static void main(String[] args) throws Exception{
		byte[] data = "The data need to be signatured".getBytes();
		KeyPairGenerator gen = KeyPairGenerator.getInstance("DSA");
		gen.initialize(1024);
		KeyPair keys = gen.genKeyPair();
		
		Signature signature = Signature.getInstance(gen.getAlgorithm());
		
		signature.initSign(keys.getPrivate());
		
		signature.update(data);
		
		byte[] sign = signature.sign();
		
		//私钥完成签名，公钥用于验证
		signature.initVerify(keys.getPublic());
		signature.update(data);
		boolean res = signature.verify(sign);
		System.out.println(res);
		
	}

}
