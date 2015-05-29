package javaencryptart.chapter7;

import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/*
 * P250 Password based encryption
 */
public class PBE {
	public static final String ALG = "PBEWithMD5andDES";
	public static final int ITERATION_COUNT = 10;
	
	public static byte[] initSalt() throws Exception{
		SecureRandom rand = new SecureRandom();
		return rand.generateSeed(8);//产生盐
	}

	//得到密钥
	private static Key toKey(String password) throws Exception {
		PBEKeySpec keyspec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory fact = SecretKeyFactory.getInstance(ALG);
		SecretKey secretKey = fact.generateSecret(keyspec);
		return secretKey;
	}

	// 解密数据
	public static byte[] decrypt(byte[] data, String password, byte[] salt) throws Exception {
		Key k = toKey(password);
		PBEParameterSpec paramSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
		Cipher cipher = Cipher.getInstance(ALG);
		cipher.init(Cipher.DECRYPT_MODE, k, paramSpec);
		return cipher.doFinal(data);
	}

	// 加密数据
	public static byte[] encrypt(byte[] data, String password,byte[] salt) throws Exception {
		
		Key k = toKey(password);
		PBEParameterSpec paramSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
		Cipher cipher = Cipher.getInstance(ALG);
		cipher.init(Cipher.ENCRYPT_MODE, k, paramSpec);
		return cipher.doFinal(data);
	}


	// Test
	public static void main(String[] args) throws Exception {
		String input = "vonzhou";
		byte[] data = input.getBytes();

		String pwd = "chownvon";
		byte[] salt = PBE.initSalt();
		System.err.println("Salt:" + Base64.encodeBase64String(salt));

		byte[] encrypted = PBE.encrypt(data, pwd, salt);
		System.err.println("After encrypted:"
				+ Base64.encodeBase64String(encrypted));

		byte[] decrypted = PBE.decrypt(encrypted, pwd, salt);
		System.out.println("After decrypted:" + new String(decrypted));
	}
}
