package NightfallPackage;

import java.util.Random;
import java.lang.Math; 
import java.util.Scanner;
import java.util.ArrayList;

public class RandomEvents {
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
	//EVENTS
		public static void randomEvent() throws InterruptedException {
			//CONTINUE FROM HERE
			System.out.println("=====================================\n");
			double event = (Math.random() * 100); 
			if(event <= 100 && event > 90) {
				System.out.println("< It Begins To Rain! Your Settlement Gathers Water.");
				int addedWater = (rand.nextInt((30 - 5) + 5) + 1);
				System.out.println("< Your Settlement Gathered " + addedWater + " Units of Water");
				MainGame.playerStats.setWater(MainGame.playerStats.getWater() + addedWater);
				Thread.sleep(1000);
			}if(event <= 90 && event > 70) {
				System.out.println("< Your Settlement Is Under Attack!");
				Thread.sleep(1000);
				MainGame.playerStats.setPlayerStatus(true);
			}if(event <= 70 && event > 50) {
				System.out.println("< Event 3");
			}if(event <= 50 && event > 40) {
				System.out.println("< Event 4");
			}if(event <= 40 && event > 30) {
				System.out.println("< Event 5");
			}if(event <= 30 && event > 20) {
				System.out.println("< Event 6");
			}if(event <= 20 && event > 5) {
				System.out.println("< Event 7");
			}if(event <= 5) {
				System.out.println("< Your Settlers Gaze Upon The Horizon and Notice A Dark Egg Dropping From The Sky...");
				Thread.sleep(1000);
				System.out.println("< The Sound Whizzing Through The Air, Its A Nuclear Bomb");
				Thread.sleep(1000);
				System.out.println("< At This Point Theres No Hope, Your Settlement is Within the Blast Radius");
				Thread.sleep(1000);
				System.out.println("< Your Settlers Say Their Final GoodBye As The Explosion Lights Up The Sky");
				Thread.sleep(1000);
				System.out.println("< The Blistering Impact Of The Sound Levels Your Whole Settlement.");
				MainGame.playerStats.setPlayerStatus(true);
			}
			System.out.println("=====================================\n");
			Thread.sleep(3000);
		}
}
