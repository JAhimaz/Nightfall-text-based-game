package com.nightfall.misc;

import java.util.Scanner;

public class Misc {
	
	public static void MenuCall(){
		int highScoreDay = 0;
		
		System.out.println("\n");
		System.out.println("========================== WELCOME TO ===============================");
		System.out.println(" #     # ###  #####  #     # ####### #######    #    #       #    ");
		System.out.println(" ##    #  #  #     # #     #    #    #         # #   #       #  ");
		System.out.println(" # #   #  #  #       #     #    #    #        #   #  #       #    ");
		System.out.println(" #  #  #  #  #  #### #######    #    #####   #     # #       #  ");
		System.out.println(" #   # #  #  #     # #     #    #    #       ####### #       #   ");
		System.out.println(" #    ##  #  #     # #     #    #    #       #     # #       #   ");
		System.out.println(" #     # ###  #####  #     #    #    #       #     # ####### ####### ");
		System.out.println("=====================================================================");
		System.out.println("\n1) START GAME");
		System.out.println("2) QUIT GAME");
		System.out.println("\nHIGHEST DAY SURVIVED: " + highScoreDay);

	}
	
	public static void EntryMessage() {
		System.out.println("\n\n===========================================================================================================");
		System.out.println("< Welcome to Nightfall! Your aim is to survive as many days as possible in a post apoctalyptic environment.");
		System.out.println("< When prompted to input select the coressponding number unless explicitly told to enter a string!");
		System.out.println("< There is little to no guidance so do your best and follow your gut.");
		System.out.println("< Good Luck!");
		System.out.println("===========================================================================================================\n");
		promptEnterKey();
		clearConsole();
	}
	
	@SuppressWarnings("resource")
	public static void promptEnterKey(){
		   System.out.println("Press \"ENTER\" To Continue...");
		   Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
	}
	
	public final static void clearConsole(){
	    try{
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows")){
	            Runtime.getRuntime().exec("cls");
	        }
	        else{
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e){
	        //  Handle any exceptions.
	    }
	}
}
