package chapter3;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyPairTest {
	public static void main(String[] args) throws Exception{
		KeyPairGenerator gen = KeyPairGenerator.getInstance("DSA");
		gen.initialize(1024);
		KeyPair keys = gen.genKeyPair();
		PublicKey pk = keys.getPublic();
		PrivateKey pri = keys.getPrivate();
		System.out.println(pk + ":" + pri);
	}

}
