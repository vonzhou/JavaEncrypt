package javaencryptart.chapter3;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;



/*
 * P108
 */
public class SSLSocketUtil {
	
	public static KeyStore getKeyStore(String keyStorePath, String pass) throws Exception{
		FileInputStream in = new FileInputStream(keyStorePath);
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(in, pass.toCharArray());
		in.close();
		
		return ks;
	}
	
	public static SSLSocketFactory getSSLSocketFactory(String keyStorePath,String pass,
			String trustKeyStorePath)	throws Exception{
		KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
		KeyStore keyStore  = getKeyStore(keyStorePath, pass);
		keyManagerFactory.init(keyStore, pass.toCharArray());
		
		TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
		KeyStore trustKeyStore = getKeyStore(trustKeyStorePath, pass);
		trustManagerFactory.init(trustKeyStore);
		
		// 初始化SSL上下文
		SSLContext ctx = SSLContext.getInstance("SSL");
		ctx.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
		
		
		SSLSocketFactory sf = ctx.getSocketFactory();
		
		return sf;
		
	}
	
	public static void httpsConnect(String urlString,
			String keyStorePath,String pass, String trustKeyStorePath) throws Exception{
		URL url = new URL(urlString);
		HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		
		conn.setSSLSocketFactory(getSSLSocketFactory(keyStorePath, pass, trustKeyStorePath));
		
		InputStream is = conn.getInputStream();
		
		int len = conn.getContentLength();
		//After connection created,we do sth ...
		
		is.close();
	}
	
	/*
	 * P113
	 * 获取数字证书
	 */
	public Certificate[] getCertificates(String host, int port) throws Exception{
		SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
		SSLSocket socket = (SSLSocket)factory.createSocket(host, port);
		
		//开始握手
		socket.startHandshake();
		
		SSLSession session = socket.getSession();
		
		socket.close();
		//通过会话获得对端的数字证书
		return session.getPeerCertificates();
		
	}
	
	

}
