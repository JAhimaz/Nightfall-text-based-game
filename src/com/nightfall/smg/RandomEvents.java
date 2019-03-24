package com.nightfall.smg;

import java.util.Random;
import java.lang.Math; 
import java.util.Scanner;

import com.nightfall.main.MainGame;
import com.nightfall.npc.Settler;

public class RandomEvents {
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
	
	static double internalEvent;
	static int affect;
	//EVENTS
		public static void randomEvent() throws InterruptedException {
			//CONTINUE FROM HERE
			System.out.println("\n=====================================");
			double event = (Math.random() * 100); 
			if(event <= 100 && event > 90) { //RainEvent
				RainEvent();
			}if(event <= 90 && event > 85) {
				System.out.println("< Your Settlement Is Under Attack!");
				Thread.sleep(1000);
				//Setup Fight System.
			}if(event <= 85 && event > 80) { //Random Storm (FUTURE WEATHERS)
				System.out.println("< Event 3");
			}if(event <= 80 && event > 70) { //Random DustStorm (FUTURE WEATHERS)
				System.out.println("< Event 4");
			}if(event <= 70 && event > 60) { //Random EarthQuake (FUTURE WEATHERS)
				System.out.println("< Event 5");
			}if(event <= 60 && event > 40) { //Strangers Join Your Settlement!
				SettlerEvent();
			}if(event <= 40 && event > 5) {
				System.out.println("< Event 7");
			}if(event <= 2) { //Nuclear Bomb
				NuclearEvent();
			}
			System.out.println("=====================================\n");
			Thread.sleep(3000);
		}
		
		private static void SettlerEvent() throws InterruptedException {
			System.out.println("< You Eye Some Strangers In The Distance! They Approach Unarmed...");
			Thread.sleep(1000);
			System.out.println("< They Approach With Caution As Your Settlers Draw Their Weapons...");
			Thread.sleep(1000);
			System.out.println("< Slowly Lowering Their Weapons, Your Settlers Welcome The New Survivors...");
			Thread.sleep(1000);
			int newSettlers = (rand.nextInt((5-2) + 2) + 1);
			for(int i = 1; i <= newSettlers; i++) {
				Settler newSettler = new Settler();
				newSettler.setHealth(rand.nextInt((100-85) + 85) + 1);
				MainGame.settlers.add(newSettler);
			}
			System.out.println("\n< You Have Gained " + newSettlers + " New Settlers!");
		}
		
		private static void NuclearEvent() throws InterruptedException {
			System.out.println("< Your Settlers Gaze Upon The Horizon and Notice A Dark Egg Dropping From The Sky...");
			Thread.sleep(1000);
			System.out.println("< The Sound Whizzing Through The Air, Its A Nuclear Bomb");
			Thread.sleep(1000);
			
			if(MainGame.settlementStats.hasBunker()) {
				System.out.println("< You're Settlers Hastily Flee To The Bunker!");
				Thread.sleep(1000);
				System.out.println("< The Doors Shut Upon The Soundwave Impact...");
				Thread.sleep(1000);
				System.out.println("< Upon Re-Entry To The Surface World You're Settlers Find Everything Wiped Out.");
				Thread.sleep(1000);
				System.out.println("< All Your Settlers Have Been Affected By Radiation...");
				Thread.sleep(1000);
				
				//Nuclear Wipeout, Resets All Stats To Zero, Settlers Healths Are All Divided By Half, Scavengers Are All Killed.
				
			}else {
				System.out.println("< At This Point Theres No Hope, Your Settlement is Within the Blast Radius");
				Thread.sleep(1000);
				System.out.println("< Your Settlers Say Their Final GoodBye As The Explosion Lights Up The Sky");
				Thread.sleep(1000);
				System.out.println("< The Blistering Impact Of The Sound Levels Your Whole Settlement.");
				MainGame.playerStats.setPlayerStatus(true);
			}
		}
		
		private static void RainEvent() throws InterruptedException {
			System.out.println("< It Begins To Rain!");
			Thread.sleep(1000);
			internalEvent = (Math.random() * 100); 
			if(internalEvent <= 15 && internalEvent >= 0) {
				System.out.println("< Its Acid Rain, Your Water Supply is Affected!");
				//Possibly harm settlers too.
				Thread.sleep(1000);
				affect = (rand.nextInt((15 - 5) + 5) + 1);
				System.out.println("< Your Settlement Lost " + affect + " Units of Water To The Acid Rain");
				MainGame.playerStats.setWater(MainGame.playerStats.getWater() - affect);
				Thread.sleep(1000);
				
				internalEvent = (Math.random() * 100);
				if(internalEvent <= 10 && internalEvent >= 0) {
					System.out.println("< The Acid Rain Also Has Ruined Your Fortifications.");
					Thread.sleep(1000);
					affect = (rand.nextInt((15 - 5) + 5) + 1);
					System.out.println("< Your Settlements Defenses Have Fallen By " + affect);
					MainGame.settlementStats.setDefense(MainGame.settlementStats.getDefense() - affect);
					Thread.sleep(1000);
				}
			}else {
				System.out.println("< The Rain Is Fresh and Drinkable!");
				Thread.sleep(1000);
				System.out.println("< Your Settlers Gather The Water For Drinking.");
				Thread.sleep(1000);
				affect = (rand.nextInt((30 - 5) + 5) + 1);
				System.out.println("< Your Settlement Gathered " + affect + " Units of Water");
				MainGame.playerStats.setWater(MainGame.playerStats.getWater() + affect);
				Thread.sleep(1000);
			}
		}
}
