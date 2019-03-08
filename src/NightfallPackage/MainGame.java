package NightfallPackage;

import java.util.Random;
import java.lang.Math; 
import java.util.Scanner;
import java.util.ArrayList;

public class MainGame {
	//Basic Java Components
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
	public final static PlayerStats playerStats = new PlayerStats();
	public final static SettlementStats settlementStats = new SettlementStats();
	ArrayList<Integer> settlementItems = new ArrayList<Integer>();
	
	//USERINPUT
	static int numberInput, dailyChoice;
	static String stringInput;
	

	
	public static void GameBoard() throws InterruptedException {
		Misc.EntryMessage();
		DefaultStats();
		//Do While Loop To End Game
		for(settlementStats.setDay(1); settlementStats.getDay() >= 1 && !playerStats.isPlayerDead(); settlementStats.incrementDay()) {	
			Scavenging.ScavengingCall();
			DayStartCall();
			System.out.println("\n< Your Scavengers Will Return in " + (MainGame.settlementStats.getEndScavenging() - MainGame.settlementStats.getScavengingDays()) + " Days");
			if(settlementStats.getDay() > 3) {
				double eventRand = (Math.random() * 100); 
				if(eventRand <= 75) {
					randomEvent();
					if(playerStats.isPlayerDead()) {
						break;
					}
				}
			}
			while(!settlementStats.isDayOver()) {
				dailyChoice = DayChoice();
				switch(dailyChoice) {
					case 1:
						Scavenging.SendScavengers();
						break;
				}
			}
			System.out.println("\n== Day " + settlementStats.getDay() + " Has Come To An End ==");	
			Thread.sleep(2000);
		}
		
		System.out.println("\n\n< YOU HAVE MADE IT TO THE END GAME AFTER " + settlementStats.getDay() + " DAYS SURVIVED");
	}
	
	public static void DefaultStats() {
		System.out.println("< Give Your Settlement A Name: ");
		System.out.print("\n> ");
		settlementStats.setSettlementName(input.nextLine());
		
		settlementStats.setSettlers(rand.nextInt((7 - 5) + 1) + 5);
		settlementStats.setDefense(50); 
		settlementStats.setHealth(100);
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
			System.out.println("\n=================================");
			
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
		settlementStats.setDayOverStatus(false);
		System.out.println("\n=================================");
		System.out.println("              DAY " + settlementStats.getDay() + "\n");
		Thread.sleep(1000);
		System.out.println("SETTLEMENT DETAILS:");
		System.out.println("Name: " + settlementStats.getSettlementName());
		if(settlementStats.isScavenging()) {
			System.out.print("Settlers: " + settlementStats.getSettlers() + " (" + settlementStats.getScavengers() + ") Scavenging\n");
		}else {
			System.out.println("Settlers: " + settlementStats.getSettlers());
		}
		System.out.println("Defense: " + settlementStats.getDefense());
		System.out.println("Health: " + settlementStats.getHealth());
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
			settlementStats.setDayOverStatus(true);
			return true;
		}
		return false;
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
			playerStats.setPlayerStatus(true);
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
			playerStats.setPlayerStatus(true);
		}
		System.out.println("=====================================\n");
		Thread.sleep(3000);
	}
}
