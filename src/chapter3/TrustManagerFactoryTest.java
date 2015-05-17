package chapter3;

import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.TrustManagerFactory;

/*
 P98
 */
public class TrustManagerFactoryTest {
	public static void main(String[] args) throws Exception{
		TrustManagerFactory fact = TrustManagerFactory.getInstance("SunX509");
		FileInputStream in = new FileInputStream("C:\\data\\keystore.jks");
		KeyStore ks = KeyStore.getInstance("JKS");
				
		ks.load(in, "vonzhou".toCharArray());
		in.close();
		
		fact.init(ks);
		System.out.println(fact.getAlgorithm());
	}
}
