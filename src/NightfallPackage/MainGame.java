package NightfallPackage;

import java.util.Random;
import java.lang.Math; 
import java.util.Scanner;
import java.util.ArrayList;

public class MainGame {
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
	public final static PlayerStats playerStats = new PlayerStats();
	public final static SettlementStats settlementStats = new SettlementStats();
	public static ArrayList<Settler> settlers = new ArrayList<Settler>();
	public static ArrayList<Settler> scavengers = new ArrayList<Settler>();
	public static ArrayList<Settler> builders = new ArrayList<Settler>();
	public static ArrayList<Integer> settlementItems = new ArrayList<Integer>();
	
	static int numberInput, dailyChoice;
	static String stringInput;
	
	public static void GameBoard() throws InterruptedException {
		Misc.EntryMessage();
		DefaultStats();
		//Do While Loop To End Game
		for(settlementStats.setDay(1); settlementStats.getDay() >= 1 && !playerStats.isPlayerDead(); settlementStats.incrementDay()) {	
			Scavenging.ScavengingCall();
			CheckFoodAndWater();
			if(playerStats.isPlayerDead())
				break;
			DayStartCall();
			if(settlementStats.getDay() > 3) {
				double eventRand = (Math.random() * 100); 
				if(eventRand <= 25) {
					RandomEvents.randomEvent();
					if(playerStats.isPlayerDead())
						break;
				}
			}
			while(!settlementStats.isDayOver()) {
				dailyChoice = DayChoice();
				switch(dailyChoice) {
					case 1:
						Scavenging.SendScavengers();
						break;
					case 2:
						//Entering The Market
						break;
					case 3:
						SettlementManagement.SMmenu();
						break;
				}
			}
			DayEndCall();
			System.out.println("\n== Day " + settlementStats.getDay() + " Has Come To An End ==");	
			Thread.sleep(2000);
		}
		
		System.out.println("\n\n< YOU HAVE MADE IT TO THE END GAME AFTER " + settlementStats.getDay() + " DAYS SURVIVED");
	}
	
	public static void DayStartCall() throws InterruptedException {

		settlementStats.setDayOverStatus(false);
		System.out.println("\n=================================");
		System.out.println("              DAY " + settlementStats.getDay() + "\n");
		Thread.sleep(1000);
		System.out.println("SETTLEMENT DETAILS:");
		System.out.println("Name: " + settlementStats.getSettlementName());
		if(settlementStats.isScavenging()) {
			System.out.print("Settlers: " + settlers.size() + " (" + scavengers.size() + ") Scavenging\n");
		}else {
			System.out.println("Settlers: " + settlers.size());
		}
		System.out.println("Defense: " + settlementStats.getDefense());
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
	
	private static void CheckFoodAndWater() {
		if(playerStats.getFood() <= 0 && !playerStats.isFoodLess()) {
			System.out.println("\n< Your Settlement Has Run Out Of Food!");
			playerStats.noFood(true);
		}
		if(playerStats.getWater() <= 0 && !playerStats.isWaterLess()) {
			System.out.println("\n< Your Settlement Has Run Out Of Water!");
			playerStats.noWater(true);
		}
		if(playerStats.getWater() <= 0) {
			playerStats.setWater(0);
			playerStats.setDaysWithoutFood(playerStats.getDaysWithoutFood() + 1);
		}
		if(playerStats.getFood() <= 0) {
			playerStats.setFood(0);
			playerStats.setDaysWithoutWater(playerStats.getDaysWithoutWater() + 1);
		}
		if(playerStats.isFoodLess() && playerStats.getFood() > 0) {
			playerStats.noFood(false);
			playerStats.setDaysWithoutFood(0);
		}
		if(playerStats.isWaterLess() && playerStats.getWater() > 0) {
			playerStats.noWater(false);
			playerStats.setDaysWithoutWater(0);
		}
		if(playerStats.getDaysWithoutFood() >= 2 || playerStats.getDaysWithoutWater() >= 2) {
			if(playerStats.getDaysWithoutFood() >= 2 && playerStats.getDaysWithoutWater() >= 2) {
				System.out.println("\n< Your Settlers Have Died From The Lack Of Food And Water!");
			}else if(playerStats.getDaysWithoutFood() >= 2) {
				System.out.println("\n< Your Settlers Have Died From The Lack Of Food!");
			}else if(playerStats.getDaysWithoutWater() >= 2) {
				System.out.println("\n< Your Settlers Have Died From The Lack Of Water!");
			}
			MainGame.playerStats.setPlayerStatus(true);
		}
	}

	public static void DayEndCall() {
		//The Settlers Consume Food/Water
		//Only Settlers Currently in the Settlement
		playerStats.setFood(playerStats.getFood() - settlers.size());
		playerStats.setWater(playerStats.getWater() - settlers.size());
	}
	
	public static int DayChoice() throws InterruptedException {
		boolean successfulChoice = false;
		int choice;
		
		do {
			System.out.println("\n=================================");
			System.out.println("What Would You Like To Do Today?");
			System.out.println("1) Send Out A Scavenging Party");
			System.out.println("2) Enter Market");
			System.out.println("3) Settlement Management ");
			System.out.println("4) View Settlers");
			System.out.println("5) Skip Turn");
			System.out.println("=================================");
			
			System.out.print("\n> ");
			choice = input.nextInt();
			input.nextLine();
			
			if(!(choice >= 1 && choice <= 5)) {
				System.out.println("\n< Please Choose A Valid Option");
			}else {
				successfulChoice = choiceChecker(choice);
			}
		}while(!successfulChoice);

		return choice;
	}
	
	public static boolean choiceChecker(int choice) throws InterruptedException {
		if(choice == 1 && !(settlementStats.isScavenging())) {
			return true;
		}else if(choice == 1 && settlementStats.isScavenging()) {
			System.out.println("\n< You Have Already Sent Out Scavengers!");
			return false;
		}
		if(choice == 2 && !(settlementStats.isMarketAttacked())) {
			return true;
		}else if(choice == 2 && settlementStats.isMarketAttacked()) {
			System.out.println("\n< The Market Has Been Attacked Recently and is Closed!");
		}
		if(choice == 3) {
			return true;
		}
		if(choice == 4) {
			System.out.println("\n============================================");
			System.out.println("\n< Current Settlers: \n");
			for(Settler settler : settlers) {
				System.out.println("- Name:  " + settler.getFirstName() + " " + settler.getLastName() + " - " +
								   "Age: " + settler.getAge() + " - " +
								   "Gender: " + settler.getGender());
				System.out.println("  Health: " + settler.getHealth());
				System.out.print("  Current Task: ");
				if(settler.isBuilding()) {
					System.out.print("Building");
				}else if(settler.isScavenging()) {
					System.out.print("Scavenging");
				}else {
					System.out.print("Idle");
				}
				System.out.println("\n");
			}
			
			for(Settler settler : scavengers) {
				System.out.println("- Name:  " + settler.getFirstName() + " " + settler.getLastName() + " - " +
								   "Age: " + settler.getAge() + " - " +
								   "Gender: " + settler.getGender());
				System.out.println("  Health: " + settler.getHealth());
				System.out.print("  Current Task: ");
				if(settler.isBuilding()) {
					System.out.print("Building");
				}else if(settler.isScavenging()) {
					System.out.print("Scavenging");
				}else {
					System.out.print("Idle");
				}
				System.out.println("\n");
				
			}
			System.out.println("============================================");
			Misc.promptEnterKey();
			return true;
		}
		if(choice == 5) {
			System.out.println("\nSkipping Day");
			settlementStats.setDayOverStatus(true);
			return true;
		}
		return false;
	}
	
	public static void DefaultStats() {
		System.out.println("< Give Your Settlement A Name: ");
		System.out.print("\n> ");
		settlementStats.setSettlementName(input.nextLine());
		
		int settlersCreated = rand.nextInt((8-4) + 1) + 4;
		for(int i = 1; i <= settlersCreated; i++) {
			Settler newSettler = new Settler();
			settlers.add(newSettler);
		}
		
		settlementStats.setDefense(50); 
		playerStats.setMetal(rand.nextInt((40 - 20) + 1) + 20); 
		playerStats.setWood(rand.nextInt((40 - 20) + 1) + 20); 
		playerStats.setWeapons(rand.nextInt((7 - 4) + 1) + 4); 
		playerStats.setFood(rand.nextInt((60 - 40) + 1) + 20);
		playerStats.setWater(rand.nextInt((60 - 40) + 1) + 20);
	}
	
}
