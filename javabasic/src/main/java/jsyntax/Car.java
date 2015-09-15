package jsyntax;

import java.io.Serializable;

public class Car implements Serializable {

	private static final long serialVersionUID = 4976426780776801695L;
	private String brand;
	private int maxSpeed;
	public Car(String brand, int maxSpeed) {
		super();
		this.brand = brand;
		this.maxSpeed = maxSpeed;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", maxSpeed=" + maxSpeed + "]";
	}
}
