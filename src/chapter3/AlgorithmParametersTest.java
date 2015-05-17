package chapter3;

import java.math.BigInteger;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;

public class AlgorithmParametersTest {
	public static void main(String[] args) throws Exception{
		AlgorithmParameters ap = AlgorithmParameters.getInstance("DES");
		
		// How TO USE ??  AlgorithmParameterGenerator
		
		ap.init((new BigInteger("19050619766489163472469")).toByteArray());
		
		byte[] b = ap.getEncoded();
		System.out.println(new BigInteger(b).toString());
		
		
	}

}
