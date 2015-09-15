package jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {

	private ElectricCar car;
	
	public InvocationHandlerImpl(ElectricCar car) {
		this.car = car;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		System.out.println("You are going to invoke "+method.getName()+" ...");
		method.invoke(car, null);
		System.out.println(method.getName()+" invocation has been finished...");
		return null;
	}

}
