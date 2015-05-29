package javaencryptart.chapter7;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/*
 * P240 AES算法
 */
public class AES {
	public static final String KEY_ALG = "AES";
	public static final String CIPHER_ALG = "AES/ECB/PKCS5Padding";

	// 由二进制字节数组得到密钥对象
	private static Key toKey(byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, KEY_ALG);
		return secretKey;
	}

	// 解密数据
	public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALG);
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	// 加密数据
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALG);
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	// 生成密钥
	public static byte[] initKey() throws Exception {
		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALG);
		kg.init(256);
		SecretKey secretKey = kg.generateKey();
		return secretKey.getEncoded();
	}

	// Test
	public static void main(String[] args) throws Exception {
		String input = "vonzhou";
		byte[] data = input.getBytes();

		byte[] key = AES.initKey();
		System.err.println("Key:" + Base64.encodeBase64String(key));

		byte[] encrypted = AES.encrypt(data, key);
		System.err.println("After encrypted:"
				+ Base64.encodeBase64String(encrypted));

		byte[] decrypted = AES.decrypt(encrypted, key);
		System.out.println("After decrypted:" + new String(decrypted));
	}
}
