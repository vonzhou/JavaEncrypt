package javaencryptart.chapter3;

import java.io.FileInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

/*
 P96
 
 使用 keytool 实用程序生成证书  http://docs.oracle.com/cd/E19900-01/820-0847/ablrb/
 
 选项:

 -alias <alias>                  要处理的条目的别名
 -keyalg <keyalg>                密钥算法名称
 -keysize <keysize>              密钥位大小
 -sigalg <sigalg>                签名算法名称
 -destalias <destalias>          目标别名
 -dname <dname>                  唯一判别名
 -startdate <startdate>          证书有效期开始日期/时间
 -ext <value>                    X.509 扩展
 -validity <valDays>             有效天数
 -keypass <arg>                  密钥口令
 -keystore <keystore>            密钥库名称
 -storepass <arg>                密钥库口令
 -storetype <storetype>          密钥库类型
 -providername <providername>    提供方名称
 -providerclass <providerclass>  提供方类名
 -providerarg <arg>              提供方参数
 -providerpath <pathlist>        提供方类路径
 -v                              详细输出
 -protected                      通过受保护的机制的口令

使用 "keytool -help" 获取所有可用命令

C:\Users\vonzhou>keytool -genkey -alias keyAlias -keyalg RSA -keypass vonzhou -s
torepass vonzhou -keystore keystore.jks
您的名字与姓氏是什么?
  [Unknown]:  chown
您的组织单位名称是什么?
  [Unknown]:  WLAN
您的组织名称是什么?
  [Unknown]:  HUST
您所在的城市或区域名称是什么?
  [Unknown]:  Wuhan
您所在的省/市/自治区名称是什么?
  [Unknown]:  Hubei
该单位的双字母国家/地区代码是什么?
  [Unknown]:  CN
CN=chown, OU=WLAN, O=HUST, L=Wuhan, ST=Hubei, C=CN是否正确?
  [否]:  y


C:\Users\vonzhou>keytool -export -alias keyAlias -storepass vonzhou -file server
.cer -keystore keystore.jks
存储在文件 <server.cer> 中的证书

C:\Users\vonzhou>
 */
public class LoadCert {
	public static void main(String[] args) throws Exception{
		CertificateFactory fact = CertificateFactory.getInstance("X.509");
		// 文件是通过keytool导出的证书文件，而非keystore文件
		FileInputStream in = new FileInputStream("C:\\data\\server.cer");
		
		System.out.println(fact.getType());
		
		Certificate cert = fact.generateCertificate(in);
		System.out.println(cert);
		
		in.close();
		
	}
}
