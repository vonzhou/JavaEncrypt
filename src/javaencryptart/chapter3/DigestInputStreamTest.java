package javaencryptart.chapter3;

import java.io.ByteArrayInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class DigestInputStreamTest {
	public static void main(String[] args) throws Exception{
		byte[] input = "vonzhou".getBytes();
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		DigestInputStream dis = new DigestInputStream(new ByteArrayInputStream(input), md);
		dis.read(input, 0, input.length);
		
		byte[] output = dis.getMessageDigest().digest();
		
		dis.close();
	}

}
