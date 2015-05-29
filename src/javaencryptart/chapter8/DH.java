package javaencryptart.chapter8;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/*
 * P273 Diffie Hellman alg
 */
public class DH {
	// 非对称加密算法 用于密钥管理
	public static final String KEY_ALG = "DH";
	// 本地密钥算法 对称加密算法可以选DES DESede AES
	public static final String SECRET_ALG = "AES";
	
	//DH算法默认的密钥长度是1024 ，密钥长度须是64的倍数 512-1024之间
	public static final int KEY_SIZE = 512;
	
	//为了保存到MAP中
	public static final String PUBLIC_KEY = "DHPublicKey";
	public static final String PRIVATE_KEY = "DHPrivateKey";
	
	//初始化甲方密钥
	public static Map<String,Object> initKey() throws Exception{
		KeyPairGenerator kpg = KeyPairGenerator.getInstance(KEY_ALG);
		kpg.initialize(KEY_SIZE);
		KeyPair keyPair = kpg.genKeyPair();
		DHPublicKey pub = (DHPublicKey)keyPair.getPublic();
		DHPrivateKey pri = (DHPrivateKey)keyPair.getPrivate();
		Map<String,Object> keymap = new HashMap<String,Object>(2);
		keymap.put(PUBLIC_KEY, pub);
		keymap.put(PRIVATE_KEY, pri);
		return keymap;
	}

	// 根据甲方公钥 初始化乙方密钥
	public static Map<String,Object> initKey(byte[] key) throws Exception{
		// 解析甲方公钥 转换公钥材料
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
		KeyFactory fact = KeyFactory.getInstance(KEY_ALG);
		PublicKey pubkey = fact.generatePublic(x509KeySpec);
		
		DHParameterSpec dhParamSpec = ((DHPublicKey)pubkey).getParams();
		KeyPairGenerator kpg = KeyPairGenerator.getInstance(fact.getAlgorithm());
		kpg.initialize(dhParamSpec);
		KeyPair keyPair = kpg.generateKeyPair();
		DHPublicKey pub = (DHPublicKey)keyPair.getPublic();
		DHPrivateKey pri = (DHPrivateKey)keyPair.getPrivate();
		Map<String,Object> keymap = new HashMap<String,Object>(2);
		keymap.put(PUBLIC_KEY, pub);
		keymap.put(PRIVATE_KEY, pri);
		return keymap;
	}
	
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception{
		SecretKey secretKey = new SecretKeySpec(key, SECRET_ALG);
		Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		return cipher.doFinal(data);
	}
	
	public static byte[] decrypt(byte[] data, byte[] key) throws Exception{
		SecretKey secretKey = new SecretKeySpec(key, SECRET_ALG);
		Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		
		return cipher.doFinal(data);
	}
	
	public static byte[] getSecretKey(byte[] publicKey, byte[] privateKey) throws Exception{
		KeyFactory fact = KeyFactory.getInstance(KEY_ALG);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
		PublicKey pub = fact.generatePublic(x509KeySpec);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);
		PrivateKey pri = fact.generatePrivate(pkcs8KeySpec);
		
		KeyAgreement keyAgree = KeyAgreement.getInstance(fact.getAlgorithm());
		keyAgree.init(pri);
		keyAgree.doPhase(pub, true);
		
		SecretKey secretKey = keyAgree.generateSecret(SECRET_ALG);
		return secretKey.getEncoded();
	}
	
	public static byte[] getPrivateKey(Map<String,Object> keymap) throws Exception{
		Key key = (Key)keymap.get(PRIVATE_KEY);
		return key.getEncoded();
	}
	
	public static byte[] getPublicKey(Map<String,Object> keymap) throws Exception{
		Key key = (Key)keymap.get(PUBLIC_KEY);
		return key.getEncoded();
	}
}

















