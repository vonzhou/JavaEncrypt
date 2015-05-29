 package javaencryptart.chapter3;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
 /*
  * P88
  */
public class ObjectEncrypt {
	public static void main(String[] args)  throws Exception{
		String input = "vonzhou";// 待加密的对象
		
		KeyGenerator gen = KeyGenerator.getInstance("DES");
		SecretKey secretKey = gen.generateKey();
		
		Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		SealedObject so = new SealedObject(input,cipher);
		
		//初始化用于解密的Cipher对象
		Cipher dipher = Cipher.getInstance(secretKey.getAlgorithm());
		dipher.init(Cipher.DECRYPT_MODE, secretKey);
		// 得到解密后的对象
		String output = (String)so.getObject(dipher);
		System.out.println(output);
	}
}
