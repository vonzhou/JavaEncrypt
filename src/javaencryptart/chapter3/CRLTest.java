package javaencryptart.chapter3;

import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;

/*
 P102   ����
 Exception in thread "main" java.security.cert.CRLException: Parsing error: algid parse error, not a sequence
	at sun.security.x509.X509CRLImpl.<init>(Unknown Source)
	at sun.security.provider.X509Factory.engineGenerateCRL(Unknown Source)
	at java.security.cert.CertificateFactory.generateCRL(Unknown Source)
	at chapter3.CRLTest.main(CRLTest.java:19)
	
TODO:  ��εõ�CRL ��
https://jamielinux.com/articles/2013/08/generate-certificate-revocation-list-revoke-certificates/
 */
public class CRLTest {
	public static void main(String[] args) throws Exception{
		CertificateFactory fact = CertificateFactory.getInstance("X.509");
		// �ļ���ͨ��keytool������֤���ļ�������keystore�ļ�
		FileInputStream in = new FileInputStream("C:\\data\\server.cer");
		//X509Certificate cert = (X509Certificate)fact.generateCertificate(in);	
		X509CRL crl = (X509CRL)fact.generateCRL(in);
		//Ȼ�������֤ balabala.....
		System.out.println(crl);
		
		in.close();
	}
}
