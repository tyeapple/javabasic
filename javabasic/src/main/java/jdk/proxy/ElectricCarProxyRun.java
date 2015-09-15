package jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ElectricCarProxyRun {

	public static void main(String[] args) {
		ElectricCar car = new ElectricCar();
		
		ClassLoader cl = car.getClass().getClassLoader();
		Class[] interfaces = car.getClass().getInterfaces();
		
		InvocationHandler handler = new InvocationHandlerImpl(car);
		
		Object obj = Proxy.newProxyInstance(cl, interfaces, handler);
		Vehicle vehicle = (Vehicle) obj;
		vehicle.drive();
		Rechargable rechargable = (Rechargable) obj;
		rechargable.recharge();
		
		ProxyUtils.generateClassFile(car.getClass(), "ElectricCarProxy1");
	}
}
