package NightfallPackage;

import java.util.Scanner;

public class Menu {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		int playerChoice;
		//Call Main Menu Function
		Misc.MenuCall();
		playerChoice = MainMenu();
		switch(playerChoice) {
			case 1:
				LoadingScreen.GameLoad();
				break;
			case 2:
				System.exit(0);
				//Quit Game
				break;
			case 3:
				MainGame.GameBoard();
				break;
			default:
				break;
		}
	}
	
	public static int MainMenu() {		
		int choice;
		System.out.print("\n> ");
		choice = input.nextInt();
		input.nextLine();
		if(!(choice >= 1 && choice <= 3)) { //Change Back to 2
			do {
				System.out.print("Please Enter A Valid Choice: ");
				choice = input.nextInt();
				input.nextLine();
			}while(!(choice >= 1 && choice <= 3));
		}	
		return choice;
	}

}
