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
		// ������Կ���ļ�
		FileInputStream in = new FileInputStream("C:\\data\\.keystore");
		System.out.println(KeyStore.getDefaultType());
		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
		
		// ������Կ�⣬ʹ����ȷ������
		//����java.io.IOException: Keystore was tampered with, or password was incorrect
		ks.load(in, "vonzhou".toCharArray());
		
		// ��ñ���"mykey"��Ӧ��˽Կ
		PrivateKey key = (PrivateKey)ks.getKey("mykey", "vonzhou".toCharArray());
		
		//��������
		ProtectionParameter protection = new KeyStore.PasswordProtection("vonzhou".toCharArray());
		KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry)ks.getEntry("mykey", protection);
		PrivateKey key2 = pkEntry.getPrivateKey();
		
		System.out.println(Arrays.toString(key.getEncoded()));
		System.out.println(Arrays.toString(key2.getEncoded()));
		
		in.close();
		
	}
}
