package jdk.annotation;

import jdk.annotation.FruitColor.Color;

public class Apple {
	
	@FruitName("Apple")
	private String appleName;
	
	@FruitColor(fruitColor=Color.RED)
	private String appleColor;
	
	@FruitProvider(id=1, name="CompanyName", address="Company address")
	private String appleProvider;
}
