package javaencryptart.chapter5;

import org.bouncycastle.util.encoders.Base64;

/*
 * P149
 */
public abstract class Base64Coder {
	//×Ö·û±àÂë
	public final static String ENCODING = "UTF-8";
	
	public static String encode(String data) throws Exception{
		byte[] b = Base64.encode(data.getBytes(ENCODING));
		return new String(b, ENCODING);
	}
	
	public static String decode(String data) throws Exception{
		byte[] b = Base64.decode(data.getBytes(ENCODING));
		return new String(b,ENCODING);
	}
}
