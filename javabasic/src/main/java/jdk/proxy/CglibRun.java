package jdk.proxy;

import net.sf.cglib.proxy.Enhancer;

public class CglibRun {

	public static void main(String[] args) {
		
		Programmer programmer = new Programmer();
		
		Hacker hacker = new Hacker();
		
		Enhancer enhancer = new Enhancer();
		
		enhancer.setSuperclass(programmer.getClass());
		enhancer.setCallback(hacker);
		
		Programmer proxy = (Programmer) enhancer.create();
		proxy.code();
	}
}
