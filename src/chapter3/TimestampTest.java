package chapter3;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.SignedObject;

/*
 * P66
 */
public class TimestampTest {
	public static void main(String[] args) throws Exception{
		byte[] data = "The data need to be signatured".getBytes();
		KeyPairGenerator gen = KeyPairGenerator.getInstance("DSA");
		gen.initialize(1024);
		KeyPair keys = gen.genKeyPair();
		
		Signature signature = Signature.getInstance(gen.getAlgorithm());
		
		SignedObject s = new SignedObject(data, keys.getPrivate(), signature);
		
		byte[] sign = s.getSignature();
		
		//私钥完成签名，公钥用于验证
		boolean res = s.verify(keys.getPublic(), signature);
		System.out.println(res);
		
	}

}
