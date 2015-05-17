package chapter3;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.KeyManagerFactory;

/*
 P98
 */
public class KeyManagerFactoryTest {
	public static void main(String[] args) throws Exception{
		KeyManagerFactory fact = KeyManagerFactory.getInstance("SunX509");
		FileInputStream in = new FileInputStream("C:\\data\\keystore.jks");
		KeyStore ks = KeyStore.getInstance("JKS");
				
		ks.load(in, "vonzhou".toCharArray());
		in.close();
		
		fact.init(ks, "vonzhou".toCharArray());
		//???得到了KeyManagerFactory 能干啥  ？
		System.out.println(fact.getAlgorithm());
	}
}
