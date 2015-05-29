package javaencryptart.chapter3;

import java.security.Provider;
import java.security.Security;
import java.util.Map;

public class AllSecurityProviders {
	public static void main(String[] args) {
		for(Provider p:Security.getProviders()){
			System.out.println(p);
			for(Map.Entry<Object, Object> entry : p.entrySet()){
				System.out.println("\t" + entry.getKey() + ":" + entry.getValue());
			}
			
		}
	}

}
