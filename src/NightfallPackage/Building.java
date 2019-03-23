package NightfallPackage;

import java.util.Random;
import java.util.Scanner;

import InputHandling.InputHandling;

public class Building {
	
	//Basic Java Components
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
	
	public static void buildingMenu() throws InterruptedException{
		int playerChoice;
		
		System.out.println("\n");
		System.out.println("============== BUILDING MENU ==============");
		System.out.println("< Currently Built:");
		System.out.println("\nBunker: " + MainGame.settlementStats.built(MainGame.settlementStats.hasBunker())); 
		System.out.println("Farm: " + MainGame.settlementStats.built(MainGame.settlementStats.hasFarm()));
		System.out.println("Forge: " + MainGame.settlementStats.built(MainGame.settlementStats.hasForge()));
		System.out.println("Crafting Building: " + MainGame.settlementStats.built(MainGame.settlementStats.hasCrafting()));
		System.out.println("Water Pump: " + MainGame.settlementStats.built(MainGame.settlementStats.hasWaterPump()));
		System.out.println("\n");
		System.out.println("1) Build");
		System.out.println("2) Back");
		
		playerChoice = BuildingMenuChoice();
		switch(playerChoice) {
			case 1:
				CreateBuilding();
				break;
			case 2:
				SettlementManagement.SMmenu();
				break;
			default:
				break;
		}	
	}
	
	private static int BuildingMenuChoice() {
		int choice;
		System.out.print("\n> ");
		choice = input.nextInt();
		input.nextLine();
		if(!(choice >= 1 && choice <= 2)) { 
			do {
				System.out.print("Please Enter A Valid Choice: ");
				choice = input.nextInt();
				input.nextLine();
			}while(!(choice >= 1 && choice <= 2));
		}	
		return choice;
	}
	
	private static void CreateBuilding() throws InterruptedException {
		int playerChoice;
		
		System.out.println("\n");
		System.out.println("============== BUILDING MENU ==============");
		System.out.println("< What Would You Like To Build?");
		System.out.println("\n1) Bunker =| 250 Metal | 100 Wood | 2 Settlers | Forge | Crafting Building |=");
		System.out.println("2) Farm =| 150 Wood | 3 Settlers | Crafting Building |=");
		System.out.println("3) Forge =| 100 Metal | 1 Settler | Crafting Building |= ");
		System.out.println("4) Crafting Building =| 50 Wood | 1 Settler |=");
		System.out.println("5) Water Pump =| 30 Metal | 1 Settler | Crafting Building |=");
		
		playerChoice = InputHandling.Integer(1, 5);
		switch(playerChoice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				break;
		}	
	}


	
}
