package com.nightfall.ioh;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandling {
	
	static Scanner input = new Scanner(System.in);
	
	public static int Integer(int minChoice, int maxChoice) throws InterruptedException {		
		int choice, error = 0;
		do {
			if(error > 0) {
				System.out.println("\nPlease Enter A Number From " + minChoice + " to " + maxChoice);
				Thread.sleep(1000);
			}
		    System.out.print("\n> ");
		    while (!input.hasNextInt()) {
		        System.out.println("\nPlease Input Only Numbers!");
		        Thread.sleep(1000);
		        System.out.print("\n> ");
		        input.next(); // this is important!
		    }
		    choice = input.nextInt();
		    error++;
		} while (!(choice >= minChoice && choice <= maxChoice));
		
		return choice;
	}
	
	public static int ScavengerHandling(int minChoice, int maxChoice) throws InterruptedException {		
		int choice, error = 0;
		do {
			if(error > 0) {
				System.out.println("\nPlease Enter A Number From " + minChoice + " to " + maxChoice);
				Thread.sleep(1000);
			}
				
		    System.out.print("\n> ");
		    while (!input.hasNextInt()) {
		        System.out.println("\nPlease Input Only Numbers!");
		        Thread.sleep(1000);
		        System.out.print("\n> ");
		        input.next(); // this is important!
		    }
		    choice = input.nextInt();
		    error++;
		} while (!(choice >= minChoice && choice <= maxChoice));
		
		return choice;
	}
}
