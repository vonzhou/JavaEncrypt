package javaencryptart.chapter5;

import org.apache.commons.codec.binary.Base64;


/*
 * P152
 */
public abstract class Base64Coder2 {
	//�ַ�����
	public final static String ENCODING = "UTF-8";
	
	public static String encode(String data) throws Exception{
		byte[] b = Base64.encodeBase64(data.getBytes(ENCODING));
		return new String(b, ENCODING);
	}
	
	//isChunked=true ,Ϊ�γ�Ϊ��ȫ����?
	// RFC2045���� ÿ��Ϊ76���ַ�������76���ַ�Ҳ����ˣ� ��ĩ�ӻس�����
	public static String encodeSafe(String data) throws Exception{
		byte[] b = Base64.encodeBase64(data.getBytes(ENCODING),true);
		return new String(b, ENCODING);
	}
	
	public static String decode(String data) throws Exception{
		byte[] b = Base64.decodeBase64(data.getBytes(ENCODING));
		return new String(b,ENCODING);
	}
}
