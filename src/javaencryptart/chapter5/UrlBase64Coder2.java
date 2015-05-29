package javaencryptart.chapter5;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.util.encoders.UrlBase64;


/*
 * P160
 */
public abstract class UrlBase64Coder2 {
	//×Ö·û±àÂë
	public final static String ENCODING = "UTF-8";
	
	public static String encode(String data) throws Exception{
		byte[] b = Base64.encodeBase64URLSafe(data.getBytes(ENCODING));
		return new String(b, ENCODING);
	}
	
	public static String decode(String data) throws Exception{
		byte[] b = Base64.decodeBase64(data.getBytes(ENCODING));
		return new String(b,ENCODING);
	}
}
