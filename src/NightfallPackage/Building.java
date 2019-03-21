package NightfallPackage;

import java.util.Random;
import java.util.Scanner;

public class Building {
	
	//Basic Java Components
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
	
	public static void buildingMenu(){
		int playerChoice;
		
		System.out.println("\n");
		System.out.println("============== BUILDING MENU ==============");
		System.out.println("Currently Built:");
		System.out.println("\nBunker: " + ""); 
		System.out.println("Farm: " + "");
		System.out.println("Forge: " + "");
		System.out.println("Crafting Building: " + "");
		System.out.println("Water Pump: " + "");
		System.out.println("\n");
		System.out.println("1) Build");
		System.out.println("2) Back");
		
		playerChoice = BuildingMenuChoice();
		switch(playerChoice) {
			case 1:
				CreateBuilding();
				break;
			case 2:
				break;
			default:
				break;
		}	
	}
	
	private static void CreateBuilding() {
		//Creating a Building
	}

	private static int BuildingMenuChoice() {
		int choice;
		System.out.print("\n> ");
		choice = input.nextInt();
		input.nextLine();
		if(!(choice >= 1 && choice <= 3)) { //Amount of settlement Choices
			do {
				System.out.print("Please Enter A Valid Choice: ");
				choice = input.nextInt();
				input.nextLine();
			}while(!(choice >= 1 && choice <= 3));
		}	
		return choice;
	}
	
}
