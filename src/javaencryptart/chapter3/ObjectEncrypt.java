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
		String input = "vonzhou";// �����ܵĶ���
		
		KeyGenerator gen = KeyGenerator.getInstance("DES");
		SecretKey secretKey = gen.generateKey();
		
		Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		SealedObject so = new SealedObject(input,cipher);
		
		//��ʼ�����ڽ��ܵ�Cipher����
		Cipher dipher = Cipher.getInstance(secretKey.getAlgorithm());
		dipher.init(Cipher.DECRYPT_MODE, secretKey);
		// �õ����ܺ�Ķ���
		String output = (String)so.getObject(dipher);
		System.out.println(output);
	}
}
