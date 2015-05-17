package chapter4;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


/*
 * P121
 * 修改了权限配置文件之后
 */
public class AESTest {
	public static void main(String[] args) throws Exception{
		KeyGenerator gen = KeyGenerator.getInstance("AES");
		gen.init(256);
		SecretKey secretKey = gen.generateKey();
		
		byte[] key = secretKey.getEncoded();
	}
}
