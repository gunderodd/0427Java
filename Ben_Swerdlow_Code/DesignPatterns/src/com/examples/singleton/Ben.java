package com.examples.singleton;

public class Ben {
	// Ben shares the car with TK
	public SingletonCar myCar = SingletonCar.getCar();
	// Any changes to car should and will affect both the car belonging to Ben's class and TK's class

}