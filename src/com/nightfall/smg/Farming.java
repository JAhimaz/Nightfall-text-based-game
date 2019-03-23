package com.nightfall.smg;

import com.nightfall.ioh.InputHandling;
import com.nightfall.main.MainGame;
import com.nightfall.settlement.SettlementManagement;

public class Farming {
	
	public static void FarmingMenu() throws InterruptedException{
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

				break;
			case 2:
				SettlementManagement.SMmenu();
				break;
			default:
				break;
		}	
	}
	
}
