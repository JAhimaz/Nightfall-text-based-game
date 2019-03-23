package com.nightfall.settlement;

import java.util.Random;
import java.util.Scanner;

import com.nightfall.ioh.InputHandling;
import com.nightfall.smg.Building;
import com.nightfall.smg.Farming;

public class SettlementManagement {
	
	//Basic Java Components
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
	
	public static void SMmenu() throws InterruptedException {
		int playerChoice;
		
		System.out.println("\n");
		System.out.println("============== SETTLEMENT MANAGEMENT ==============");
		System.out.println("< What Would You Like To Manage In Your Settlement?");
		System.out.println("\n1) Building"); 
		System.out.println("2) Farming");
		System.out.println("3) Back");
		
		playerChoice = InputHandling.Integer(1, 3);
		switch(playerChoice) {
			case 1:
				Building.BuildingMenu();
				break;
			case 2:
				Farming.FarmingMenu();
				break;
			case 3:
				break;
			default:
				break;
		}	
	}

}
