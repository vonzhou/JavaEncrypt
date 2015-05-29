 package javaencryptart.chapter3;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
 /*
  * 86
  */
public class StoreEncrypt2File {
	public static void main(String[] args)  throws Exception{
		KeyGenerator gen = KeyGenerator.getInstance("DES");
		SecretKey secretKey = gen.generateKey();
		
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		//Ҫ���ܵ�ԭʼ�ļ�
		String input = "vonzhou go for it";
		
		CipherOutputStream cos = new CipherOutputStream(new FileOutputStream("C:/data/secret"), cipher);
		DataOutputStream dos = new DataOutputStream(cos);
		// �������д�����ܵ����ݣ����ջᱻ����
		dos.writeUTF(input);
		
		dos.flush();
		dos.close();
	}

}
