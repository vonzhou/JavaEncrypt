package chapter3;

import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


/*
 * //P62
 */
public class SecureRandomTest {
	public static void main(String[] args) throws Exception{
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		SecureRandom ran = new SecureRandom();
		
		kg.init(ran);
		
		SecretKey key = kg.generateKey();
		System.out.println(key.getEncoded().length);
		System.out.println(key.getFormat());
	}

}
