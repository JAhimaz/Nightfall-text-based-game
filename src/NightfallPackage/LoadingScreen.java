package NightfallPackage;

public class LoadingScreen {
	public static void GameLoad() throws InterruptedException{
		LoadingLoop();
		MainGame.GameBoard();
	}
	
	public static void LoadingLoop() throws InterruptedException {
		System.out.println("\nLoading Wasteland...");
		Thread.sleep(1500);
		System.out.println("Loading Random Weapons...");
		Thread.sleep(400);
		System.out.println("Loading Metal Sheets...");
		Thread.sleep(300);
		System.out.println("Dropping Nukes...");
		Thread.sleep(600);
		System.out.println("Filling Up Canteens...");
		Thread.sleep(600);
		System.out.println("Shooting Annoying Neighbours...");
		Thread.sleep(200);
		System.out.println("Saving Hobbits From Isengard...");
		Thread.sleep(100);
		System.out.println("Locked and Loaded...");
		Thread.sleep(600);
	}
}

