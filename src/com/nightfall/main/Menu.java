package com.nightfall.main;

import java.util.Scanner;

import com.nightfall.ioh.InputHandling;
import com.nightfall.misc.LoadingScreen;
import com.nightfall.misc.Misc;

public class Menu {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		int playerChoice;
		//Call Main Menu Function
		Misc.MenuCall();
		playerChoice = InputHandling.Integer(1, 3);
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

}
