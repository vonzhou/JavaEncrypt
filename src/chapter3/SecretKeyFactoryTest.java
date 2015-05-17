package chapter3;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;


/*
 * 80
 */
public class SecretKeyFactoryTest {
	public static void main(String[] args) throws Exception{
		// DES�ԳƼ����㷨��Կ������
		KeyGenerator gen = KeyGenerator.getInstance("DES");
		//������Կ
		SecretKey key = gen.generateKey();
		
		byte[] kbytes = key.getEncoded();
		
		//������Կ�淶����
		DESKeySpec spec = new DESKeySpec(kbytes);
		//��Կ��������
		SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
		//ͨ����Կ�淶������������Կ
		SecretKey key2 = factory.generateSecret(spec);
	}

}
