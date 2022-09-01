package com.zookeeper;

public class Bat extends Mammal {

	public Bat() {
		super(300);
	}
	
	public Bat(int energyLevel) {
		super(energyLevel);
	}

	public void fly() {
		System.out.println("The bat flys, flap flap.");
		energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("The bat eats a human.");
		energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("The town is on fire.");
		energyLevel -= 100;
	}
}
