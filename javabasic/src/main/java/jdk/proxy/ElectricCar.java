package jdk.proxy;

public class ElectricCar implements Vehicle, Rechargable {

	@Override
	public void recharge() {
		System.out.println("Electric Car is recharging...");
	}

	@Override
	public void drive() {
		System.out.println("Electric Car is moving silently...");
	}

	
}
