package NightfallPackage;

import java.util.Random;
import java.util.Scanner;

public class Scavenging {
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
	//SCAVENGING
	
	public static void ScavengingCall() throws InterruptedException{
		if(MainGame.settlementStats.isScavenging() && MainGame.settlementStats.getScavengingDays() == MainGame.settlementStats.getEndScavenging()) {
			ReturnScavengers();
			Thread.sleep(3000);
		}
		else if(MainGame.settlementStats.isScavenging()) {
			MainGame.settlementStats.incrementScaveningDays();
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

			if(MainGame.settlementStats.getSettlers() <= choice) {
				System.out.println("\n< You Don't Have That Many Settlers!");
			}else if(Math.abs((MainGame.settlementStats.getSettlers()-choice)) <= 2){
				System.out.println("\n< You Need Atleast 2 Settlers In Your Base!");
			}else if(choice == 0) {
				System.out.println("\n< Returning To Daily Choice!");
				successfulChoice = true;
			}else {
				System.out.println("\n< You Have Sent Out " + choice + " Scavengers!\n");
				if(MainGame.playerStats.getWeapons() < choice) {
					int currentWeapons = MainGame.playerStats.getWeapons();
					MainGame.playerStats.setWeapons(MainGame.playerStats.getWeapons() - MainGame.playerStats.getWeapons());
					System.out.println("< " + (choice-currentWeapons) + " Scavengers Dont Have Weapons To Defend Themselves.");
					MainGame.settlementStats.setScavengerswGuns(currentWeapons);
					MainGame.settlementStats.setScavengerswoGuns(choice-currentWeapons);
				}else {
					MainGame.playerStats.setWeapons(MainGame.playerStats.getWeapons() - choice);
					MainGame.settlementStats.setScavengerswGuns(choice);
					MainGame.settlementStats.setScavengerswoGuns(0);
				}
				MainGame.settlementStats.setSettlers(MainGame.settlementStats.getSettlers() - choice);
				MainGame.settlementStats.setScavengers(choice);
				MainGame.settlementStats.setScavengingStatus(true);
				MainGame.settlementStats.setScavengingDays(0);
				MainGame.settlementStats.setEndScavenging(rand.nextInt((5 - 1) + 1) + 1);
				System.out.println("< Your Scavengers Will Return in " + MainGame.settlementStats.getEndScavenging() + " Days");
				successfulChoice = true;
				MainGame.settlementStats.setDayOverStatus(true);
			}
		}while(!successfulChoice);
	}
	
	public static void ReturnScavengers() {
		MainGame.settlementStats.setScavengingStatus(false); MainGame.settlementStats.setSettlers(MainGame.settlementStats.getSettlers() + MainGame.settlementStats.getScavengers());
		MainGame.playerStats.setWeapons(MainGame.playerStats.getWeapons() + MainGame.settlementStats.getScavengers());
		int metalFound = (MainGame.settlementStats.getScavengingDays() * (rand.nextInt((5 - 1) + 1) + 1)) * MainGame.settlementStats.getScavengers();
		int woodFound = (MainGame.settlementStats.getScavengingDays() * (rand.nextInt((5 - 1) + 1) + 1)) * MainGame.settlementStats.getScavengers();
		int foodFound = (MainGame.settlementStats.getScavengingDays() * (rand.nextInt((5 - 1) + 1) + 1)) * MainGame.settlementStats.getScavengers();
		int waterFound = (MainGame.settlementStats.getScavengingDays() * (rand.nextInt((5 - 1) + 1) + 1)) * MainGame.settlementStats.getScavengers();
		System.out.println("\n< Your Scavengers Have Returned With The Following");
		System.out.println("Metal: " + metalFound);
		System.out.println("Wood: " + woodFound);
		System.out.println("Food: " + foodFound);
		System.out.println("Water: " + waterFound);
		MainGame.playerStats.setMetal(MainGame.playerStats.getMetal() + metalFound); MainGame.playerStats.setWood(MainGame.playerStats.getWood() + woodFound); 
		MainGame.playerStats.setFood(MainGame.playerStats.getFood() + foodFound); MainGame.playerStats.setWater(MainGame.playerStats.getWater() + waterFound);
		MainGame.settlementStats.setScavengers(0);
		MainGame.settlementStats.setScavengerswGuns(0);
		MainGame.settlementStats.setScavengerswoGuns(0);
		MainGame.settlementStats.setScavengingDays(0);
		MainGame.settlementStats.setEndScavenging(0);
	}
}
