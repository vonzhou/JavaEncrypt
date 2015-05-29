package javaencryptart.chapter3;

import java.security.MessageDigest;
import java.util.Arrays;

public class DigestTest{
	public static void main(String[] args)  throws Exception{
		byte[] input = "vonzhou".getBytes();
		MessageDigest sha = MessageDigest.getInstance("SHA");
		sha.update(input);
		byte[] output = sha.digest();
		System.out.println(sha);
		
	}

}
