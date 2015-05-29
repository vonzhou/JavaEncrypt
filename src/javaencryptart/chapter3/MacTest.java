package javaencryptart.chapter3;

import java.util.Arrays;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

/*
 * P75
 */
public class MacTest {
	public static void main(String[] args) throws Exception{
		byte[] input = "hello security".getBytes();
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		SecretKey key = keyGenerator.generateKey();
		
		Mac mac = Mac.getInstance(key.getAlgorithm());
		mac.init(key);
		
		//Do not forget update it first
		// java.security.cert.CertificateException: Could not parse certificate: java.io.IOException: Empty input
		mac.update(input);
		
		byte[] output = mac.doFinal(input);
		
		System.out.println(key.getFormat());
		System.out.println(mac.getAlgorithm());
		System.out.println(mac.getMacLength());
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(output));
	}

}
