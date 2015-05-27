package chapter7;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/*
 * P244  IDEA(International Data Encryption Algorithm)
 */
public class IDEA {
	public static final String KEY_ALG = "IDEA";
	public static final String CIPHER_ALG = "IDEA/ECB/ISO10126Padding";

	// 由二进制字节数组得到密钥对象
	private static Key toKey(byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, KEY_ALG);
		return secretKey;
	}

	// 解密数据
	public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALG);
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	// 加密数据
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALG);
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	// 生成密钥
	public static byte[] initKey() throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		
		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALG);
		kg.init(128);
		SecretKey secretKey = kg.generateKey();
		return secretKey.getEncoded();
	}

	// Test
	public static void main(String[] args) throws Exception {
		String input = "vonzhou";
		byte[] data = input.getBytes();

		byte[] key = IDEA.initKey();
		System.err.println("Key:" + Base64.encodeBase64String(key));

		byte[] encrypted = IDEA.encrypt(data, key);
		System.err.println("After encrypted:"
				+ Base64.encodeBase64String(encrypted));

		byte[] decrypted = IDEA.decrypt(encrypted, key);
		System.out.println("After decrypted:" + new String(decrypted));
	}
}
