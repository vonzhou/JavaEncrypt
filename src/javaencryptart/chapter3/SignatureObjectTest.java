package javaencryptart.chapter3;

import java.io.FileInputStream;
import java.security.Timestamp;
import java.security.cert.CertPath;
import java.security.cert.CertificateFactory;
import java.util.Date;

/*
 * P66
 */
public class SignatureObjectTest {
	public static void main(String[] args) throws Exception{
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		// 使用Makecert工具创建一个证书 ，以供使用,但是还是失败了 
		//java.security.cert.CertificateException: Could not parse certificate: java.io.IOException: Empty input
		//证书路径
		CertPath cp = cf.generateCertPath(new FileInputStream("C:\\data\\testCer.cer"));
		Timestamp t = new Timestamp(new Date(), cp);
		
	}

}
