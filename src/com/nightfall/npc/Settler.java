package com.nightfall.npc;

import java.util.Random;

import com.nightfall.rand.RandomDetail;

public class Settler {
	static Random rand = new Random();
	
	//Settler Details
	//Final
	private String firstName;
	private String lastName;
	private char gender;
	
	//Interchangeable
	private int age;
	private int health;
	
	private boolean isScavenging, isBuilding, isHungry, hasGun;
	
	//Default Value Setter
	public Settler() {
		this.gender = RandomDetail.randomGender(); //Randomly Chosen
		this.firstName = RandomDetail.firstName(gender); //Random Generation based on gender
		this.lastName = RandomDetail.lastName(); //Random Generation
		
		this.age = (rand.nextInt((40 - 20) + 1) + 20); //All settlers found will be above 20 unless born.
		
		this.health = 100; //health is 100 by default
		this.isScavenging = false;
		this.isBuilding = false;
		this.isHungry = false;
		this.hasGun = false;
	}
	
	//GETTERS
	public int getHealth() {
		return health;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Character getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	//SETTERS
	public void setHealth(int health) {
		this.health = health;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public boolean isScavenging() {
		return isScavenging;
	}

	public void setScavenging(boolean isScavenging) {
		this.isScavenging = isScavenging;
	}

	public boolean isBuilding() {
		return isBuilding;
	}

	public void setBuilding(boolean isBuilding) {
		this.isBuilding = isBuilding;
	}

	public boolean isHungry() {
		return isHungry;
	}

	public void setHungry(boolean isHungry) {
		this.isHungry = isHungry;
	}

	public boolean hasGun() {
		return hasGun;
	}

	public void setHasGun(boolean hasGun) {
		this.hasGun = hasGun;
	}



}
