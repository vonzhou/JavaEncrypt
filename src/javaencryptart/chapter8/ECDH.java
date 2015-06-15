package javaencryptart.chapter8;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

/*
 * Õ÷‘≤«˙œﬂ Diffie-Hellman (ECDH) 
 */
public class ECDH {
	
	public static final String KEY_ALG = "ECDH";
	public static final String SECRET_ALG = "Blowfish";
	//ECDH default key size is 256, range is 112 to 571..
	public static final int KEY_SIZE = 256;
	
	// intend to put it in a map , so need a string key
	public static final String PUBLIC_KEY = "ECPublicKey";
	public static final String PRIVATE_KEY = "ECPrivateKey";
	
	// init A's key map
	public static Map<String,Object> initKey() throws Exception{
		KeyPairGenerator kpg = KeyPairGenerator.getInstance(KEY_ALG);
		kpg.initialize(KEY_SIZE);
		KeyPair keyPair = kpg.genKeyPair();
		// A's public key and private key
		ECPublicKey publicKey = (ECPublicKey)keyPair.getPublic();
		ECPrivateKey privateKey = (ECPrivateKey)keyPair.getPrivate();
		
		Map<String, Object> keymap = new HashMap<String, Object>(2);
		keymap.put(PUBLIC_KEY, publicKey);
		keymap.put(PRIVATE_KEY, privateKey);
		
		return keymap;
	}
	
	// Get B's key map according to A's public key bytes....
	public static Map<String,Object> initKey(byte[] key) throws Exception{
		// A's public key material
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
	
	

}
