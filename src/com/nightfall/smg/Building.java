package com.nightfall.smg;

import java.util.Random;
import java.util.Scanner;

import com.nightfall.ioh.InputHandling;
import com.nightfall.main.MainGame;
import com.nightfall.settlement.SettlementManagement;

public class Building {
	
	//Basic Java Components
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
	
	public static void BuildingMenu() throws InterruptedException{
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
		
		playerChoice = InputHandling.Integer(1, 2);
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
				MainGame.settlementStats.setDayOverStatus(true);
				break;
			case 2:
				MainGame.settlementStats.setDayOverStatus(true);
				break;
			case 3:
				MainGame.settlementStats.setDayOverStatus(true);
				break;
			case 4:
				MainGame.settlementStats.setDayOverStatus(true);
				break;
			case 5:
				MainGame.settlementStats.setDayOverStatus(true);
				break;
			default:
				MainGame.settlementStats.setDayOverStatus(true);
				break;
		}	
	}


	
}
