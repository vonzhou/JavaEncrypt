package chapter4;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


/*
 * P121
 * �޸���Ȩ�������ļ�֮��
 */
public class AESTest {
	public static void main(String[] args) throws Exception{
		KeyGenerator gen = KeyGenerator.getInstance("AES");
		gen.init(256);
		SecretKey secretKey = gen.generateKey();
		
		byte[] key = secretKey.getEncoded();
	}
}
