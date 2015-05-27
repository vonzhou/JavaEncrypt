package chapter6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.security.DigestInputStream;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;


/*
 * P220
 * 通过MD5值来校验下载的文件
 * 软件包openssl-1.0.2a.tar.gz  MD5值在 openssl-1.0.2a.tar.gz.md5文件中
 */
public class FileIntegrityCheck {

	public static void testByMessageDigest(String filePath,String md5Path) throws Exception{
		FileInputStream fis = new FileInputStream(new File(filePath));
		DigestInputStream dis = new DigestInputStream(fis, MessageDigest.getInstance("MD5"));
		
		int len = 1024;
		byte[] buf = new byte[len];
		int read = -1;
		while((read=dis.read(buf, 0, len)) > -1)
			;
		
		dis.close();
		MessageDigest md = dis.getMessageDigest();
		byte[] b = md.digest();
		String md5Hex = Hex.encodeHexString(b);
		
		//从文件中读取原始的MD5
		BufferedReader br = new BufferedReader(new FileReader(md5Path));
		String right = br.readLine();
		br.close();
		
		System.out.println(md5Hex.equals(right));
	}
	
	public static void testByMessageDigest2(String filePath,String md5Path) throws Exception{
		FileInputStream fis = new FileInputStream(new File(filePath));
		String md5Hex = DigestUtils.md5Hex(fis);
		
		//从文件中读取原始的MD5
		BufferedReader br = new BufferedReader(new FileReader(md5Path));
		String right = br.readLine();
		br.close();
		
		System.out.println(md5Hex.equals(right));
	}
	
	public static void main(String[] args) throws Exception{
		String filePath = "E:/Downloads/openssl-1.0.2a.tar.gz";
		String md5Path = "E:/Downloads/openssl-1.0.2a.tar.gz.md5";
		testByMessageDigest2(filePath, md5Path);
	}
}
