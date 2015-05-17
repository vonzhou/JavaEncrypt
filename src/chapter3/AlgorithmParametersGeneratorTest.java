package chapter3;

import java.math.BigInteger;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.Security;

public class AlgorithmParametersGeneratorTest {
	public static void main(String[] args) throws Exception{
		
		//Security.addProvider()
		
		AlgorithmParameterGenerator apg = AlgorithmParameterGenerator.getInstance("DES");
		apg.init(56);
		AlgorithmParameters ap = apg.generateParameters();
		
		byte[] b = ap.getEncoded();
		
		System.out.println(new BigInteger(b).toString());
		
		
	}

}
/* ÎªºÎ±¨´í  £¿£¿
 Exception in thread "main" java.security.NoSuchAlgorithmException: DES AlgorithmParameterGenerator not available
	at sun.security.jca.GetInstance.getInstance(Unknown Source)
	at java.security.Security.getImpl(Unknown Source)
	at java.security.AlgorithmParameterGenerator.getInstance(Unknown Source)
  
 */
 
