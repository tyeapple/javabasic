package jdk.security;

import java.security.AccessController;
import java.security.PrivilegedAction;

public class PrivilegeTest {

	public static void main(String[] args) {
		String name = System.getProperty("user.name");
		System.out.println("user.name="+name);
		
		String user = AccessController.doPrivileged(
	          new PrivilegedAction<String>() {
	          public String run() {
	        	  return sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
	              }
	          });
		System.out.println("user.name="+user);
		
		
//		long maxDirectMemory = sun.misc.VM.maxDirectMemory();
//		System.out.println(maxDirectMemory/1024/1024);
//		String p1 = sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
		
		 String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
		
	}
}
