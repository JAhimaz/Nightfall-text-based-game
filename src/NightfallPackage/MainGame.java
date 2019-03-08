package NightfallPackage;

import java.util.Random;
import java.lang.Math; 
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
	static int day, scavengingDays, endScavenging;
	//SETTLEMENT DETAILS
	static String settlementName;
	static int settlers,
			   defense,
			   scavengers, scavengerswGuns, scavengerswoGuns,
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
			ScavengingCall();
			DayStartCall();
			if(day > 3) {
				double eventRand = (Math.random() * 100); 
				if(eventRand <= 75) {
					System.out.println("\nAn Event Has Occured!");
					randomEvent();
					if(playerDead) {
						break;
					}
				}
			}
			while(!dayOver) {
				dailyChoice = DayChoice();
				switch(dailyChoice) {
					case 1:
						SendScavengers();
						break;
				}
			}
			System.out.println("\nDay " + day + " Has Come To An End");	
		}
		
		System.out.println("\n\n< YOU HAVE MADE IT TO THE END GAME AFTER " + day + " DAYS SURVIVED");
	}
	
	public static void DefaultStats() {
		System.out.println("< Give Your Settlement A Name: ");
		System.out.print("\n> ");
		settlementName = input.nextLine();
		
		settlers = rand.nextInt((7 - 5) + 1) + 5; defense = 50; health = 100;
		playerStats.setMetal(rand.nextInt((40 - 20) + 1) + 20); 
		playerStats.setWood(rand.nextInt((40 - 20) + 1) + 20); 
		playerStats.setWeapons(rand.nextInt((7 - 4) + 1) + 4); 
		playerStats.setFood(rand.nextInt((60 - 40) + 1) + 20);
		playerStats.setWater(rand.nextInt((60 - 40) + 1) + 20);
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
				System.out.println("\n< Please Choose A Valid Option");
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
		if(isScavenging) {
			System.out.print("Settlers: " + settlers + " (" + scavengers + ") Scavenging\n");
		}else {
			System.out.println("Settlers: " + settlers);
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
			System.out.println("\n< You Have Already Sent Out Scavengers!");
			return false;
		}
		if(choice == 2 && !marketAttacked) {
			return true;
		}else if(choice == 2 && marketAttacked) {
			System.out.println("\n< The Market Has Been Attacked Recently and is Closed!");
		}
		if(choice == 3) {
			return true;
		}
		if(choice == 4) {
			dayOver = true;
			return true;
		}
		return false;
	}
	
	//SCAVENGING
	
	public static void ScavengingCall() throws InterruptedException{
		if(isScavenging && scavengingDays == endScavenging) {
			ReturnScavengers();
			Thread.sleep(3000);
		}
		else if(isScavenging) {
			scavengingDays++;
		}
	}
	
	public static void SendScavengers() {
		boolean successfulChoice = false;
		int choice;
		
		do {
			System.out.println("\n< How Many Scavengers Do You Want To Send Out? (0 To Cancel)");
			
			while(true) {
				System.out.print("\n> ");
				choice = input.nextInt();
				input.nextLine();
				//CONTINUE FROM HERE
				break;
			}

			if(settlers <= choice) {
				System.out.println("\n< You Don't Have That Many Settlers!");
			}else if(Math.abs((settlers-choice)) <= 2){
				System.out.println("\n< You Need Atleast 2 Settlers In Your Base!");
			}else if(choice == 0) {
				System.out.println("\n< Returning To Daily Choice!");
				successfulChoice = true;
			}else {
				System.out.println("\n< You Have Sent Out " + choice + " Scavengers!\n");
				if(playerStats.getWeapons() < choice) {
					int currentWeapons = playerStats.getWeapons();
					playerStats.setWeapons(playerStats.getWeapons() - playerStats.getWeapons());
					System.out.println("< " + (choice-currentWeapons) + " Scavengers Dont Have Weapons To Defend Themselves.");
					scavengerswGuns = currentWeapons;
					scavengerswoGuns = choice-currentWeapons;
				}else {
					playerStats.setWeapons(playerStats.getWeapons() - choice);
					scavengerswGuns = choice;
					scavengerswoGuns = 0;
				}
				settlers -= choice;
				scavengers = choice;
				isScavenging = true;
				scavengingDays = 0;
				endScavenging = rand.nextInt((5 - 1) + 1) + 1;
				successfulChoice = true;
				dayOver = true;
			}
		}while(!successfulChoice);
	}
	
	public static void ReturnScavengers() {
		isScavenging = false; settlers += scavengers; playerStats.setWeapons(playerStats.getWeapons() + scavengers); scavengers = 0;scavengerswGuns = 0; scavengerswoGuns = 0;
		int metalFound = (scavengingDays * (rand.nextInt((5 - 1) + 1) + 1));
		int woodFound = (scavengingDays * (rand.nextInt((5 - 1) + 1) + 1));
		int foodFound = (scavengingDays * (rand.nextInt((5 - 1) + 1) + 1));
		int waterFound = (scavengingDays * (rand.nextInt((5 - 1) + 1) + 1));
		System.out.println("\n< Your Scavengers Have Returned With The Following");
		System.out.println("Metal: " + metalFound);
		System.out.println("Wood: " + woodFound);
		System.out.println("Food: " + foodFound);
		System.out.println("Water: " + waterFound);
		playerStats.setMetal(playerStats.getMetal() + metalFound); playerStats.setWood(playerStats.getWood() + woodFound); 
		playerStats.setFood(playerStats.getFood() + foodFound); playerStats.setWater(playerStats.getWater() + waterFound);
		scavengingDays = 0;
		endScavenging = 0;
	}
	
	//EVENTS
	
	public static void randomEvent() throws InterruptedException {
		//CONTINUE FROM HERE
		System.out.println("=====================================\n");
		double event = (Math.random() * 100); 
		if(event <= 100 && event > 90) {
			System.out.println("< It Begins To Rain! Your Settlement Gathers Water.");
			int addedWater = (rand.nextInt((30 - 5) + 5) + 1);
			System.out.println("< Your Settlement Gathered " + addedWater + " Units of Water");
			playerStats.setWater(playerStats.getWater() + addedWater);
			Thread.sleep(1000);
		}if(event <= 90 && event > 70) {
			System.out.println("< Your Settlement Is Under Attack!");
			Thread.sleep(1000);
			playerDead = true;
		}if(event <= 70 && event > 50) {
			System.out.println("< Event 3");
		}if(event <= 50 && event > 40) {
			System.out.println("< Event 4");
		}if(event <= 40 && event > 30) {
			System.out.println("< Event 5");
		}if(event <= 30 && event > 20) {
			System.out.println("< Event 6");
		}if(event <= 20 && event > 5) {
			System.out.println("< Event 7");
		}if(event <= 5) {
			System.out.println("< Your Settlers Gaze Upon The Horizon and Notice A Dark Egg Dropping From The Sky...");
			Thread.sleep(1000);
			System.out.println("< The Sound Whizzing Through The Air, Its A Nuclear Bomb");
			Thread.sleep(1000);
			System.out.println("< At This Point Theres No Hope, Your Settlement is Within the Blast Radius");
			Thread.sleep(1000);
			System.out.println("< Your Settlers Say Their Final GoodBye As The Explosion Lights Up The Sky");
			Thread.sleep(1000);
			System.out.println("< The Blistering Impact Of The Sound Levels Your Whole Settlement.");
			playerDead = true;
		}
	}
}
