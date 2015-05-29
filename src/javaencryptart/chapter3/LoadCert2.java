package javaencryptart.chapter3;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/*
 P98
 */
public class LoadCert2 {
	public static void main(String[] args) throws Exception{
		CertificateFactory fact = CertificateFactory.getInstance("X.509");
		// �ļ���ͨ��keytool������֤���ļ�������keystore�ļ�
		FileInputStream in = new FileInputStream("C:\\data\\keystore.jks");
		// ������Կ���ļ�
		KeyStore ks = KeyStore.getInstance("JKS");
				
		// ������Կ�⣬ʹ����ȷ������
		//����java.io.IOException: Keystore was tampered with, or password was incorrect
		ks.load(in, "vonzhou".toCharArray());
		in.close();
				
		// ��ñ���"keyAlias"��Ӧ���C��
		X509Certificate cert = (X509Certificate)ks.getCertificate("keyAlias");
		//���ǩ��
		Signature sign = Signature.getInstance(cert.getSigAlgName());
		//Ȼ�������֤ balabala.....
		System.out.println(cert.getIssuerX500Principal());
		System.out.println("---------------------------");
		System.out.println(cert);
	}
}
