package jdk.classloader;

import java.util.ServiceLoader;

public class MyServiceLoader {
	
	public static void main(String[] args) {
		
		ServiceLoader<MessageService> serviceLoader = ServiceLoader.load(MessageService.class);
		for(MessageService service : serviceLoader) {
			System.out.println(service.getMessage());
		}
	}

}
