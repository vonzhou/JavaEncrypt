package chapter3;

import java.io.ByteArrayOutputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;

public class DigestOutputStreamTest {
	public static void main(String[] args) throws Exception{
		byte[] input = "P4ssw0rd".getBytes();
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		DigestOutputStream dos = new DigestOutputStream(new ByteArrayOutputStream(), md);
		dos.write(input, 0, input.length);
		byte[] output = dos.getMessageDigest().digest();
		dos.flush();
		dos.close();
	}

}
