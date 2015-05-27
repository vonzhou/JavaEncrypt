package chapter7;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;

/*
 * P229 DES�㷨
 */
public class DES {
	public static final String KEY_ALG = "DES";
	public static final String CIPHER_ALG = "DES/ECB/PKCS5Padding";

	// �ɶ������ֽ�����õ���Կ����
	private static Key toKey(byte[] key) throws Exception {
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALG);
		SecretKey secretKey = keyFactory.generateSecret(dks);
		return secretKey;
	}

	// ��������
	public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALG);
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	// ��������
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALG);
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}
	
	// ������Կ
	public static byte[] initKey() throws Exception{
		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALG);
		kg.init(56);
		SecretKey secretKey = kg.generateKey();
		return secretKey.getEncoded();
	}
	
	public static void main(String[] args) throws Exception {
		String input = "vonzhou";
		byte[] data = input.getBytes();
		
		byte[] key = DES.initKey();
		System.err.println("Key:" + Base64.encodeBase64String(key));
		
		byte[] encrypted = DES.encrypt(data, key);
		System.err.println("After encrypted:" + Base64.encodeBase64String(encrypted));
		
		byte[] decrypted = DES.decrypt(encrypted, key);
		System.out.println("After decrypted:" + new String(decrypted));
	}

}
