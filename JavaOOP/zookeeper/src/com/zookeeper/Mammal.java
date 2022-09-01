package com.zookeeper;

public class Mammal {
	protected int energyLevel = 100;
	
	public Mammal() {
		
	}
	
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int displayEnergy() {
		System.out.println(String.format("Energy Level: %d", energyLevel));
		return energyLevel;
	}
	
}
