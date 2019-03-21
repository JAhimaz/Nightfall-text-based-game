package NightfallPackage;

import java.util.Random;
import java.util.Scanner;

public class SettlementManagement {
	
	//Basic Java Components
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
	
	public static void SMmenu() throws InterruptedException {
		int playerChoice;
		//Call Main Menu Function
		Misc.SettlementManagementMenu();
		playerChoice = SMmenuChoice();
		switch(playerChoice) {
			case 1:
				
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
		}	
	}
	
	public static int SMmenuChoice() {
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
