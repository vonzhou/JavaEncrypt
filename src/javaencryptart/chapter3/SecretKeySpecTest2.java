package javaencryptart.chapter3;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

/*
 * P92
 */
public class SecretKeySpecTest2 {
	public static void main(String[] args) throws Exception{
		KeyGenerator gen = KeyGenerator.getInstance("DES");
		SecretKey secretKey = gen.generateKey();
		byte[] kbs = secretKey.getEncoded();
		
		//ͨ���ֽ����黹ԭ������Կ����
		SecretKey sk  =new SecretKeySpec(kbs, "DES");	
		
		
		//--------------ʹ��DESKeySpec������------------//
		DESKeySpec desks = new DESKeySpec(kbs);
		SecretKeyFactory fact = SecretKeyFactory.getInstance("DES");
		SecretKey sk2 = fact.generateSecret(desks);
		
		
		
	}

}
