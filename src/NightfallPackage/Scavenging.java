package NightfallPackage;

import java.util.Random;
import java.util.Scanner;

public class Scavenging {
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);

	public static void ScavengingCall() throws InterruptedException{
		if(MainGame.settlementStats.isScavenging() && MainGame.settlementStats.getScavengingDays() == MainGame.settlementStats.getEndScavenging()) {
			ReturnScavengers();
			Thread.sleep(3000);
		}
		else if(MainGame.settlementStats.isScavenging()) {
			MainGame.settlementStats.incrementScaveningDays();
			if(MainGame.settlementStats.getScavengingDays() > 0) {
				System.out.println("\n< Your Scavengers Will Return in " + (((MainGame.settlementStats.getEndScavenging() - MainGame.settlementStats.getScavengingDays())) + 1) + " Days");
			}
		}
	}
	
	public static void SendScavengers() {
		boolean successfulChoice = false, limit = false;
		int choice;
		
		do {
			do {
				if(MainGame.settlers.size() == 2) {
					System.out.println("You need atleast 2 Settlers In Your Base, Sending out the currently Chosen Scavengers");
					break;
				}
				if(MainGame.scavengers.size() == 4) { //Edit According to Scavenging Level
					
				}
				
				System.out.println("\n< Who Do You Want To Send Out? (0 To Send Selected | -1 to Cancel)");
				System.out.println("============================================");
				System.out.println("\n< Current Settlers: \n");
				int id = 1;
				for(Settler settler : MainGame.settlers) {
					if(settler.getAge() >= 20 && settler.getAge() <= 60) {
						System.out.println(id + ") Name:  " + settler.getFirstName() + " " + settler.getLastName());
						System.out.println("  Health: " + settler.getHealth());
						//Could Print Out Perks When Done
					}
					++id;
				}
				System.out.println("============================================");
				System.out.println("\n< Chosen Scavengers: \n");
				if(MainGame.scavengers.size() == 0) {
					System.out.println("No-one Has Been Chosen Yet..");
				}else {
					id = 1;
					for(Settler scavenger : MainGame.scavengers) {					
						System.out.println(id + ") Name:  " + scavenger.getFirstName() + " " + scavenger.getLastName());
						System.out.println("  Health: " + scavenger.getHealth());
						//Could Print Out Perks When Done
						++id;
					}
				}
				System.out.println("============================================");
		
				System.out.print("\n> ");
				choice = input.nextInt();
				input.nextLine();
				if(!(choice >= 0 && choice <= MainGame.settlers.size())) {
					do {
						System.out.print("Please Enter A Valid Choice: ");
						choice = input.nextInt();
						input.nextLine();
					}while(!(choice >= 0 && choice <= MainGame.settlers.size()));
				}else if(choice == -1) {
					System.out.println("\n< Returning To Daily Choice!");
					successfulChoice = true;
				}else if(choice == 0) {
					break;
				}else{
					Settler removed = MainGame.settlers.remove(choice-1);
					MainGame.scavengers.add(removed);
				}
			}while(choice != 0 || limit == true);
			System.out.println("> Sending Out " + MainGame.scavengers.size() + " Scavengers!");		
//			if(MainGame.playerStats.getWeapons() < MainGame.scavengers.size()) {
//
//			}else {
//
//			}	
			MainGame.settlementStats.setScavengingStatus(true);
			MainGame.settlementStats.setScavengingDays(0);
			MainGame.settlementStats.setEndScavenging(rand.nextInt((5 - 1) + 1) + 1);
//			System.out.println("< Your Scavengers Will Return in " + MainGame.settlementStats.getEndScavenging() + " Days");
			successfulChoice = true;
			MainGame.settlementStats.setDayOverStatus(true);
			
		}while(!successfulChoice);
	}
	
	public static void ReturnScavengers() {
		MainGame.settlementStats.setScavengingStatus(false); 		
		//PUT WEAPONS BACK
		int metalFound = (MainGame.settlementStats.getScavengingDays() * (rand.nextInt((5 - 1) + 1) + 1)) * MainGame.scavengers.size();
		int woodFound = (MainGame.settlementStats.getScavengingDays() * (rand.nextInt((5 - 1) + 1) + 1)) * MainGame.scavengers.size();
		int foodFound = (MainGame.settlementStats.getScavengingDays() * (rand.nextInt((5 - 1) + 1) + 1)) * MainGame.scavengers.size();
		int waterFound = (MainGame.settlementStats.getScavengingDays() * (rand.nextInt((5 - 1) + 1) + 1)) * MainGame.scavengers.size();
		System.out.println("\n< Your Scavengers Have Returned With The Following");
		System.out.println("Metal: " + metalFound);
		System.out.println("Wood: " + woodFound);
		System.out.println("Food: " + foodFound);
		System.out.println("Water: " + waterFound);
		MainGame.playerStats.setMetal(MainGame.playerStats.getMetal() + metalFound); MainGame.playerStats.setWood(MainGame.playerStats.getWood() + woodFound); 
		MainGame.playerStats.setFood(MainGame.playerStats.getFood() + foodFound); MainGame.playerStats.setWater(MainGame.playerStats.getWater() + waterFound);
		//REMOVE FROM SCAVENGERS AND PUT BACK IN SETTLERS
		int Length = MainGame.scavengers.size();
		for(int i = 0; i <= Length; i++) {
			Settler removed = MainGame.scavengers.remove(i);
			MainGame.settlers.add(removed);
		}
		MainGame.settlementStats.setScavengingDays(0);
		MainGame.settlementStats.setEndScavenging(0);
	}
}
