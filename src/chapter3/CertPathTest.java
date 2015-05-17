package chapter3;

import java.io.FileInputStream;
import java.security.cert.CertPath;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/*
 * P103
 */
public class CertPathTest {
	public static void main(String[] args) throws Exception{
		CertificateFactory fact = CertificateFactory.getInstance("X.509");
		FileInputStream in = new FileInputStream("C:\\data\\server.cer");
		X509Certificate cert = (X509Certificate)fact.generateCertificate(in);	
		System.out.println(cert.getType());
		
		CertPath path = fact.generateCertPath(in);
		//  java.security.cert.CertificateException: Empty input  ?????
		
		System.out.println(path);
		in.close();
	}
}
