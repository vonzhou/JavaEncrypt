package javaencryptart.chapter3;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;


/*
 * 78
 * ע�����˼·      http://en.wikipedia.org/wiki/Diffie%E2%80%93Hellman_key_exchange
 */
public class DHKeyExchange {
	public static void main(String[] args) throws Exception{
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
		KeyPair kp1 = kpg.genKeyPair();
		KeyPair kp2 = kpg.genKeyPair();
		
		KeyAgreement keyAgree = KeyAgreement.getInstance(kpg.getAlgorithm());
		keyAgree.init(kp2.getPrivate());
		
		// ִ�мƻ�
		keyAgree.doPhase(kp2.getPublic(), true);
		
		//�õ�һ���ԳƼ����㷨DES��������Կ����
		SecretKey key = keyAgree.generateSecret("DES");
	}

}
