package NightfallPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadingScreen {
	
	static Random rand = new Random();
	static List<String> loadingList = new ArrayList<String>();
	
	public static void GameLoad() throws InterruptedException{
		LoadingLoop();
		MainGame.GameBoard();
	}
	
	public static void shuffle(Object[] array) {
		int noOfElements = array.length;
		
		for(int i = 0; i < noOfElements; i++) {
			int s = i + (int)(Math.random() * (noOfElements - i));
			
			Object temp = array[s];
			array[s] = array[i];
			array[i] = temp;
		}
	}
	
	public static void LoadingLoop() throws InterruptedException {
		String[] loadingLines = {
				"Loading Wasteland...",
				"Loading Random Weapons...",
				"Loading Metal Sheets...",
				"Dropping Nukes...",
				"Filling Up Canteens...",
				"Shooting Annoying Neighbours...",
				"Saving Hobbits From Isengard...",
				"Locking and Loading...",
				"Picking Up The Dirt...",
				"Placing Dirt...",
				"Throwing Enemies Somewhere...",
				"Randomising Random Events...",
				"Dropping The Night...",
				"Killing Off The Remaining Humans...",
				"Blowing Up Dinosaurs...",
				"Sending The Final Memes...",
				"Wasting the land...",
		};
		
		shuffle(loadingLines);
		
		System.out.println("");
		for(int i = 0; i <= 6; i++) {
			System.out.println(loadingLines[i]);
			int timer = (rand.nextInt((1200-200) + 1500) + 1);
			Thread.sleep(timer);
		}
		
	}
}

