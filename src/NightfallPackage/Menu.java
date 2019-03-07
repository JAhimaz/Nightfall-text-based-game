package NightfallPackage;

import java.util.Scanner;

public class Menu {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		int playerChoice;
		//Call Main Menu Function
		Misc.MenuCall();
		playerChoice = Menu();
		switch(playerChoice) {
			case 1:
				LoadingScreen.GameLoad();
				break;
			case 2:
				System.exit(0);
				//Quit Game
				break;
			default:
				break;
		}
	}
	
	public static int Menu() {		
		int choice;
		System.out.print("\n> ");
		choice = input.nextInt();
		input.nextLine();
		if(!(choice >= 1 && choice <= 2)) {
			do {
				System.out.print("Please Enter A Valid Choice: ");
				choice = input.nextInt();
				input.nextLine();
			}while(!(choice >= 1 && choice <= 2));
		}	
		return choice;
	}

}
