package com.zookeeper;

public class Gorilla extends Mammal {
	
	public Gorilla() {
		super();
	}
	
	public Gorilla(int energyLevel) {
		super(energyLevel);
	}
	
	public void throwSomething() {
		System.out.println("The gorilla throws something.");
		this.energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("The gorilla's satisfaction and increase its energy by 10.");
		this.energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("The gorilla has climbed a tree and decrease its energy by 10.");
		this.energyLevel -= 10;
	}

}
