package jdk.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;

public class FileSystemClassLoader extends ClassLoader {

	private String rootDir;
	
	public FileSystemClassLoader() {}
	
	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		
		byte[] classData = getClassData(name);
		if(classData == null)
			throw new ClassNotFoundException();
		else
			return defineClass(name, classData, 0, classData.length);
	}
	
	private byte[] getClassData(String className) {
		
		String path = classNameToPath(className);
		InputStream ins = null;
		try{
			ins = new FileInputStream(path);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bufferSize = 4096;
			byte[] buffer = new byte[bufferSize];
			int bytesNumRead = 0;
			while((bytesNumRead = ins.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesNumRead);
			}
			return baos.toByteArray();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	private String classNameToPath(String className) {
		return rootDir + File.separatorChar + className.replace('.', File.separatorChar)+".class";
	}

	
	@Test
	public void test() throws ClassNotFoundException {

		String name = System.getProperty("user.dir") + "\\target\\classes\\";
		FileSystemClassLoader loader = new FileSystemClassLoader(name);
		Class<?> c = loader.findClass("com.petertian.jdk.Sample");
		
		System.out.println(c.getName());
		
	}
	
	@Test
	public void test1() throws MalformedURLException {
		
		String name = System.getProperty("user.dir") + "\\target\\classes\\";
		FileSystemClassLoader loader1 = new FileSystemClassLoader(name);
		FileSystemClassLoader loader2 = new FileSystemClassLoader(name);
		
		String className = "com.petertian.jdk.Sample";
		try {
			Class<?> class1 = loader1.findClass(className);
			Object obj1 = class1.newInstance();
			
			Class<?> class2 = loader2.findClass(className);
			Object obj2 = class2.newInstance();
			
			Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
			//setSampleMethod.invoke(obj1, obj2);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printProperties() {
		
		Properties props = System.getProperties();
		for(Map.Entry<Object, Object> entry : props.entrySet()) {
			String k = (String)entry.getKey();
			String v = (String)entry.getValue();
			
			System.out.println("k="+k+", v="+v);
		}
	}
}
