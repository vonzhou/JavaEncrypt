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
		
		//通过字节数组还原秘密密钥对象
		SecretKey sk  =new SecretKeySpec(kbs, "DES");	
		
		
		//--------------使用DESKeySpec的做法------------//
		DESKeySpec desks = new DESKeySpec(kbs);
		SecretKeyFactory fact = SecretKeyFactory.getInstance("DES");
		SecretKey sk2 = fact.generateSecret(desks);
		
		
		
	}

}
