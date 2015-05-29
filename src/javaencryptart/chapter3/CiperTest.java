package javaencryptart.chapter3;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


/*
 * P84
 */
public class CiperTest {
	public static void main(String[] args) throws Exception{
		KeyGenerator gen = KeyGenerator.getInstance("DES");
		SecretKey secretKey = gen.generateKey();
		
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		// wrap the key mode
		cipher.init(Cipher.WRAP_MODE, secretKey);
		// 
		byte[] wrapk = cipher.wrap(secretKey);
		
		//blabala  Ȼ�󴫵ݸ������һ��
		cipher.init(Cipher.UNWRAP_MODE, secretKey);
		Key key= cipher.unwrap(wrapk, "DES", Cipher.SECRET_KEY);
		
		
		
		
	}
}
