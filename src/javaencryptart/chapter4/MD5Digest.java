package javaencryptart.chapter4;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;


/*
 * P141
 */
public class MD5Digest {
	public static void main(String[] args){
		String str = "ÊÀ½çÄãºÃ£¡";
		System.err.println(str);
		byte[] input = str.getBytes();
		
		String data = DigestUtils.md5Hex(input);
		System.err.println(data);
	}

}
