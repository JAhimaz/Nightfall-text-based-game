package NightfallPackage;

import java.util.Random;
import java.util.Scanner;

public class MainGame {
	//Basic Java Components
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
	final static PlayerStats playerStats = new PlayerStats();
	
	//USERINPUT
	static int numberInput, dailyChoice;
	static String stringInput;
	
	//CURRENTPULLEDSTATS
	static int day;
	//SETTLEMENT DETAILS
	static String settlementName;
	static int settlers,
			   defense,
			   scavengers,
			   health;		
	//PLAYERSTATE
	static boolean playerDead = false,
				   isScavenging = false,
				   marketAttacked = false,
				   dayOver = false;
	
	public static void GameBoard() throws InterruptedException {
		Misc.EntryMessage();
		DefaultStats();
		//Do While Loop To End Game
		for(day = 1; day >= 1 && !playerDead; day++) {
			
			DayStartCall();
			if(day > 3) {
				System.out.println("A EVENT HAS STRUCK");
				//Random Events have a 75% chance of happening
				//After 3 Days Random Events Start
			}
			while(!dayOver) {
				dailyChoice = DayChoice();
				switch(dailyChoice) {
					case 1:
						SendScavengers();
						break;
				}
			}
			System.out.println("Day " + day + " Has Come To An End");
			
		}
	}
	
	public static void DefaultStats() {
		System.out.println("Give Your Settlement A Name: ");
		System.out.print("\n> ");
		settlementName = input.nextLine();
		
		settlers = rand.nextInt((7 - 5) + 1) + 5; defense = 50; health = 100;
		playerStats.setMetal(20); playerStats.setWood(20); playerStats.setWeapons(5); playerStats.setFood(20); playerStats.setWater(20);
	}
	
	public static int DayChoice() {
		boolean successfulChoice = false;
		int choice;
		
		do {
			System.out.println("\n=================================");
			System.out.println("What Would You Like To Do Today?");
			System.out.println("1) Send Out A Scavenging Party");
			System.out.println("2) Enter Market");
			System.out.println("3) Rebuild Settlement ");
			System.out.println("4) Skip Turn");
			
			System.out.print("\n> ");
			choice = input.nextInt();
			input.nextLine();
			
			if(!(choice >= 1 && choice <= 4)) {
				System.out.println("\nPlease Choose A Valid Option");
			}else {
				successfulChoice = choiceChecker(choice);
			}
		}while(!successfulChoice);

		return choice;
	}
	
	public static void DayStartCall() throws InterruptedException {
		dayOver = false;
		System.out.println("\n=================================");
		System.out.println("           DAY " + day + "\n");
		Thread.sleep(1000);
		System.out.println("SETTLEMENT DETAILS:");
		System.out.println("Name: " + settlementName);
		System.out.print("Settlers: " + settlers);
		if(isScavenging) {
			System.out.print(" + (" + scavengers + ") Scavenging\n");
		}
		System.out.println("Defense: " + defense);
		System.out.println("Health: " + health);
		Thread.sleep(1000);
		System.out.println("\nCURRENT COMPONENTS:");
		System.out.println("Metal: " + playerStats.getMetal());
		System.out.println("Wood: " + playerStats.getWood());
		System.out.println("Weapons: " + playerStats.getWeapons());
		System.out.println("Food: " + playerStats.getFood());
		System.out.println("Water: " + playerStats.getWater());
		System.out.println("=================================");
		Thread.sleep(1000);
	}
	
	public static boolean choiceChecker(int choice) {
		if(choice == 1 && !isScavenging) {
			return true;
		}else if(choice == 1 && isScavenging) {
			System.out.println("\nYou Have Already Sent Out Scavengers!");
			return false;
		}
		if(choice == 2 && !marketAttacked) {
			return true;
		}else if(choice == 2 && marketAttacked) {
			System.out.println("\nThe Market Has Been Attacked Recently and is Closed!");
		}
		if(choice == 3) {
			return true;
		}
		if(choice == 4) {
			return true;
		}
		return false;
	}
	
	public static void SendScavengers() {
		boolean successfulChoice = false;
		int choice;
		
		do {
			System.out.println("\nHow Many Scavengers Do You Want To Send Out? (0 To Cancel)");
			
			while(true) {
				System.out.print("\n> ");
				choice = input.nextInt();
				input.nextLine();
				//CONTINUE FROM HERE
				break;
			}

			if(settlers <= choice) {
				System.out.println("\nYou Don't Have That Many Settlers!");
			}else if(Math.abs((settlers-choice)) <= 2){
				System.out.println("\nYou Need Atleast 2 Settlers In Your Base!");
			}else if(choice == 0) {
				System.out.println("\nReturning To Daily Choice!");
				successfulChoice = true;
			}else {
				System.out.println("\nYou Have Sent Out " + choice + " Scavengers!\n");
				//SETUP WEAPON SYSTEM
				settlers -= choice;
				scavengers = choice;
				isScavenging = true;
				successfulChoice = true;
				dayOver = true;
			}
		}while(!successfulChoice);
	}
}
