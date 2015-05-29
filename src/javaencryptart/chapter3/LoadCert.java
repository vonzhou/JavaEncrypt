package javaencryptart.chapter3;

import java.io.FileInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

/*
 P96
 
 ʹ�� keytool ʵ�ó�������֤��  http://docs.oracle.com/cd/E19900-01/820-0847/ablrb/
 
 ѡ��:

 -alias <alias>                  Ҫ�������Ŀ�ı���
 -keyalg <keyalg>                ��Կ�㷨����
 -keysize <keysize>              ��Կλ��С
 -sigalg <sigalg>                ǩ���㷨����
 -destalias <destalias>          Ŀ�����
 -dname <dname>                  Ψһ�б���
 -startdate <startdate>          ֤����Ч�ڿ�ʼ����/ʱ��
 -ext <value>                    X.509 ��չ
 -validity <valDays>             ��Ч����
 -keypass <arg>                  ��Կ����
 -keystore <keystore>            ��Կ������
 -storepass <arg>                ��Կ�����
 -storetype <storetype>          ��Կ������
 -providername <providername>    �ṩ������
 -providerclass <providerclass>  �ṩ������
 -providerarg <arg>              �ṩ������
 -providerpath <pathlist>        �ṩ����·��
 -v                              ��ϸ���
 -protected                      ͨ���ܱ����Ļ��ƵĿ���

ʹ�� "keytool -help" ��ȡ���п�������

C:\Users\vonzhou>keytool -genkey -alias keyAlias -keyalg RSA -keypass vonzhou -s
torepass vonzhou -keystore keystore.jks
����������������ʲô?
  [Unknown]:  chown
������֯��λ������ʲô?
  [Unknown]:  WLAN
������֯������ʲô?
  [Unknown]:  HUST
�����ڵĳ��л�����������ʲô?
  [Unknown]:  Wuhan
�����ڵ�ʡ/��/������������ʲô?
  [Unknown]:  Hubei
�õ�λ��˫��ĸ����/����������ʲô?
  [Unknown]:  CN
CN=chown, OU=WLAN, O=HUST, L=Wuhan, ST=Hubei, C=CN�Ƿ���ȷ?
  [��]:  y


C:\Users\vonzhou>keytool -export -alias keyAlias -storepass vonzhou -file server
.cer -keystore keystore.jks
�洢���ļ� <server.cer> �е�֤��

C:\Users\vonzhou>
 */
public class LoadCert {
	public static void main(String[] args) throws Exception{
		CertificateFactory fact = CertificateFactory.getInstance("X.509");
		// �ļ���ͨ��keytool������֤���ļ�������keystore�ļ�
		FileInputStream in = new FileInputStream("C:\\data\\server.cer");
		
		System.out.println(fact.getType());
		
		Certificate cert = fact.generateCertificate(in);
		System.out.println(cert);
		
		in.close();
		
	}
}
