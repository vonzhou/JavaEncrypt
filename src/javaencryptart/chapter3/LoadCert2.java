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
		// 文件是通过keytool导出的证书文件，而非keystore文件
		FileInputStream in = new FileInputStream("C:\\data\\keystore.jks");
		// 加载密钥库文件
		KeyStore ks = KeyStore.getInstance("JKS");
				
		// 加载密钥库，使用正确的密码
		//否则java.io.IOException: Keystore was tampered with, or password was incorrect
		ks.load(in, "vonzhou".toCharArray());
		in.close();
				
		// 获得别名"keyAlias"对应的證書
		X509Certificate cert = (X509Certificate)ks.getCertificate("keyAlias");
		//获得签名
		Signature sign = Signature.getInstance(cert.getSigAlgName());
		//然后可以验证 balabala.....
		System.out.println(cert.getIssuerX500Principal());
		System.out.println("---------------------------");
		System.out.println(cert);
	}
}
