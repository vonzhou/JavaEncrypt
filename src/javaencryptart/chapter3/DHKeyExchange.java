package javaencryptart.chapter3;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;


/*
 * 78
 * 注意理解思路      http://en.wikipedia.org/wiki/Diffie%E2%80%93Hellman_key_exchange
 */
public class DHKeyExchange {
	public static void main(String[] args) throws Exception{
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
		KeyPair kp1 = kpg.genKeyPair();
		KeyPair kp2 = kpg.genKeyPair();
		
		KeyAgreement keyAgree = KeyAgreement.getInstance(kpg.getAlgorithm());
		keyAgree.init(kp2.getPrivate());
		
		// 执行计划
		keyAgree.doPhase(kp2.getPublic(), true);
		
		//得到一个对称加密算法DES的秘密密钥对象
		SecretKey key = keyAgree.generateSecret("DES");
	}

}
