package javaencryptart.chapter5;

import org.apache.commons.codec.binary.Base64;


/*
 * P152
 */
public abstract class Base64Coder2 {
	//字符编码
	public final static String ENCODING = "UTF-8";
	
	public static String encode(String data) throws Exception{
		byte[] b = Base64.encodeBase64(data.getBytes(ENCODING));
		return new String(b, ENCODING);
	}
	
	//isChunked=true ,为何称为安全编码?
	// RFC2045定义 每行为76个字符（不够76个字符也是如此） 行末加回车换行
	public static String encodeSafe(String data) throws Exception{
		byte[] b = Base64.encodeBase64(data.getBytes(ENCODING),true);
		return new String(b, ENCODING);
	}
	
	public static String decode(String data) throws Exception{
		byte[] b = Base64.decodeBase64(data.getBytes(ENCODING));
		return new String(b,ENCODING);
	}
}
