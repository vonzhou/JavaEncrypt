package javaencryptart.chapter8;

import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.util.Arrays;

public class DHTest {
	private byte[] pubKey1;
	private byte[] priKey1;
	private byte[] key1;
	
	private byte[] pubKey2;
	private byte[] priKey2;
	private byte[] key2;

	public  void initKey() throws Exception{
		Map<String,Object> keymap1 = DH.initKey();
		pubKey1 = DH.getPublicKey(keymap1);
		priKey1 = DH.getPrivateKey(keymap1);
		System.out.println("甲方公钥："+ Base64.encodeBase64String(pubKey1));
		System.out.println("甲方私钥："+ Base64.encodeBase64String(priKey1));
		
		// 由甲方的公钥产生本地密钥对
		Map<String,Object> keymap2 = DH.initKey(pubKey1);
		pubKey2 = DH.getPublicKey(keymap2);
		priKey2 = DH.getPrivateKey(keymap2);
		System.out.println("乙方公钥："+ Base64.encodeBase64String(pubKey2));
		System.out.println("乙方私钥："+ Base64.encodeBase64String(priKey2));
		
		key1 = DH.getSecretKey(pubKey2, priKey1);
		key2 = DH.getSecretKey(pubKey1, priKey2);
		System.err.println("甲方本地密钥："+Base64.encodeBase64String(key1));
		System.err.println("乙方本地密钥："+Base64.encodeBase64String(key2));
		
		/*
		 * 有了密钥自然就是加密  然后发送给对方 进行解密
		 */
		System.out.println(Arrays.areEqual(key1, key2));
	}
	
	public static void main(String[] args)  throws Exception{
		DHTest t = new DHTest();
		t.initKey();
	}
}
