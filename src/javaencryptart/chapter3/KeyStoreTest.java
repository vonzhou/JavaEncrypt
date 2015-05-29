package javaencryptart.chapter3;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.KeyStore.PasswordProtection;
import java.security.KeyStore.ProtectionParameter;
import java.security.PrivateKey;
import java.util.Arrays;

/*
 * P73
 */
public class KeyStoreTest {
	public static void main(String[] args) throws Exception{
		// 加载密钥库文件
		FileInputStream in = new FileInputStream("C:\\data\\.keystore");
		System.out.println(KeyStore.getDefaultType());
		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
		
		// 加载密钥库，使用正确的密码
		//否则java.io.IOException: Keystore was tampered with, or password was incorrect
		ks.load(in, "vonzhou".toCharArray());
		
		// 获得别名"mykey"对应的私钥
		PrivateKey key = (PrivateKey)ks.getKey("mykey", "vonzhou".toCharArray());
		
		//或者这样
		ProtectionParameter protection = new KeyStore.PasswordProtection("vonzhou".toCharArray());
		KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry)ks.getEntry("mykey", protection);
		PrivateKey key2 = pkEntry.getPrivateKey();
		
		System.out.println(Arrays.toString(key.getEncoded()));
		System.out.println(Arrays.toString(key2.getEncoded()));
		
		in.close();
		
	}
}
