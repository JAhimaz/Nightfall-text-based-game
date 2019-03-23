package NightfallPackage;

import java.util.Random;
import java.util.Scanner;

import InputHandling.InputHandling;

public class SettlementManagement {
	
	//Basic Java Components
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
	
	public static void SMmenu() throws InterruptedException {
		int playerChoice;
		//Call Main Menu Function
		Misc.SettlementManagementMenu();
		playerChoice = InputHandling.Integer(1, 3);
		switch(playerChoice) {
			case 1:
				Building.buildingMenu();
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
		}	
	}

}
