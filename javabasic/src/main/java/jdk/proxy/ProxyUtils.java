package jdk.proxy;

import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

public class ProxyUtils {

	public static void generateClassFile(Class<?> clazz, String proxyName) {
		
		byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
		String paths = clazz.getResource(".").getPath();
		System.out.println(paths);
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream(paths+proxyName+".class");
			out.write(classFile);
			out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try{
				out.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
