package com.nightfall.building;

import java.util.Random;
import java.util.Scanner;

import com.nightfall.ioh.InputHandling;
import com.nightfall.main.MainGame;
import com.nightfall.misc.Misc;
import com.nightfall.npc.Settler;
import com.nightfall.settlement.PlayerStats;
import com.nightfall.settlement.SettlementManagement;

public class Building {
	
	//Basic Java Components
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
	
	public static void BuildingMenu() throws InterruptedException{
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
				CreateBuilding();
				break;
			case 2:
				SettlementManagement.SMmenu();
				break;
			default:
				break;
		}	
	}
	
	private static void CreateBuilding() throws InterruptedException {
		int playerChoice;
		boolean successfulChoice = false;
		
		System.out.println("\n");
		System.out.println("============== BUILDING MENU ==============");
		System.out.println("< What Would You Like To Build?");
		System.out.println("\n1) Bunker =| 250 Metal | 100 Wood | 2 Settlers | Forge | Crafting Building |=");
		System.out.println("2) Farm =| 150 Wood | 3 Settlers | Crafting Building |=");
		System.out.println("3) Forge =| 100 Metal | 1 Settler | Crafting Building |= ");
		System.out.println("4) Crafting Building =| 50 Wood | 1 Settler |=");
		System.out.println("5) Water Pump =| 30 Metal | 1 Settler | Crafting Building |=");
		System.out.println("\n6) Back");
		
		playerChoice = InputHandling.Integer(1, 6);
		switch(playerChoice) {
			case 1:
				//Bunker
				if(MainGame.settlementStats.hasBunker() || MainGame.settlementStats.isBunkerBeingBuilt()) {
					if(MainGame.settlementStats.hasBunker()) {
						System.out.println("\n< You Already Have A Bunker!");
					}else if(MainGame.settlementStats.isBunkerBeingBuilt()) {
						System.out.println("\n< You Are Already Building A Bunker!");
					}

					Thread.sleep(1500);
					Misc.clearConsole();
					CreateBuilding();
					break;
				}
				
				if(MainGame.playerStats.getMetal() >= 250 &&
				   MainGame.playerStats.getWood() >= 100 &&
				   MainGame.settlers.size() > 2 &&
				   MainGame.settlementStats.hasForge() &&
				   MainGame.settlementStats.hasCrafting()) {
				
					if(MainGame.settlers.size() <= 2) {
						System.out.println("\n< You Need Atleast 3 Settlers To Build A Bunker (Requires 2 To Build And 1 Normal Settler)");
						Thread.sleep(1500);
						Misc.clearConsole();
						CreateBuilding();
					}else {
						successfulChoice = ChooseBuilders(1);
					}
				}else {
					System.out.println("\n< You Don't Have The Required Resources\n");
					if(MainGame.playerStats.getMetal() <= 1) {
						System.out.println("> Not Enough Metal!");
					}
					if(MainGame.playerStats.getWood() <= 1) {
						System.out.println("> Not Enough Wood!");
					}
					if(MainGame.settlers.size() <= 2) {
						System.out.println("> Not Enough Settlers!\n");
					}
					//Tell Them Which Resources They Dont Have
					Thread.sleep(1500);
					Misc.clearConsole();
					CreateBuilding();
				}
				
				if(successfulChoice) {
					MainGame.settlementStats.setDayOverStatus(true);
				}else if(!successfulChoice) {
					BuildingMenu();
				}

				break;
			case 2:
				if(MainGame.settlementStats.hasFarm() || MainGame.settlementStats.isFarmBeingBuilt()) {
					if(MainGame.settlementStats.hasFarm()) {
						System.out.println("\n< You Already Have A Farm!");
					}else if(MainGame.settlementStats.isFarmBeingBuilt()) {
						System.out.println("\n< You Are Already Building A Farm!");
					}

					Thread.sleep(1500);
					Misc.clearConsole();
					CreateBuilding();
					break;
				}
				
				if(MainGame.playerStats.getWood() >= 150 &&
				   MainGame.settlers.size() > 4 &&
				   MainGame.settlementStats.hasCrafting()) {
				
					if(MainGame.settlers.size() <= 4) {
						System.out.println("\n< You Need Atleast 4 Settlers To Build A Farm (Requires 3 To Build And 1 Normal Settler)");
						Thread.sleep(1500);
						Misc.clearConsole();
						CreateBuilding();
					}else {
						successfulChoice = ChooseBuilders(2);
					}
				}else {
					System.out.println("\n< You Don't Have The Required Resources\n");
					if(MainGame.playerStats.getMetal() <= 1) {
						System.out.println("> Not Enough Metal!");
					}
					if(MainGame.playerStats.getWood() <= 1) {
						System.out.println("> Not Enough Wood!");
					}
					if(MainGame.settlers.size() <= 2) {
						System.out.println("> Not Enough Settlers!\n");
					}
					//Tell Them Which Resources They Dont Have
					Thread.sleep(1500);
					Misc.clearConsole();
					CreateBuilding();
				}
				
				if(successfulChoice) {
					MainGame.settlementStats.setDayOverStatus(true);
				}else if(!successfulChoice) {
					BuildingMenu();
				}
				break;
			case 3:
				if(MainGame.settlementStats.hasForge() || MainGame.settlementStats.isForgeBeingBuilt()) {
					if(MainGame.settlementStats.hasForge()) {
						System.out.println("\n< You Already Have A Forge!");
					}else if(MainGame.settlementStats.isForgeBeingBuilt()) {
						System.out.println("\n< You Are Already Building A Forge!");
					}

					Thread.sleep(1500);
					Misc.clearConsole();
					CreateBuilding();
					break;
				}
				
				if(MainGame.playerStats.getMetal() >= 100 &&
				   MainGame.settlers.size() > 2 &&
				   MainGame.settlementStats.hasCrafting()) {
				
					if(MainGame.settlers.size() <= 2) {
						System.out.println("\n< You Need Atleast 2 Settlers To Build A Farm (Requires 1 To Build And 1 Normal Settler)");
						Thread.sleep(1500);
						Misc.clearConsole();
						CreateBuilding();
					}else {
						successfulChoice = ChooseBuilders(3);
					}
				}else {
					System.out.println("\n< You Don't Have The Required Resources\n");
					if(MainGame.playerStats.getMetal() <= 1) {
						System.out.println("> Not Enough Metal!");
					}
					if(MainGame.playerStats.getWood() <= 1) {
						System.out.println("> Not Enough Wood!");
					}
					if(MainGame.settlers.size() <= 2) {
						System.out.println("> Not Enough Settlers!\n");
					}
					//Tell Them Which Resources They Dont Have
					Thread.sleep(1500);
					Misc.clearConsole();
					CreateBuilding();
				}
				
				if(successfulChoice) {
					MainGame.settlementStats.setDayOverStatus(true);
				}else if(!successfulChoice) {
					BuildingMenu();
				}

				break;
			case 4:
				if(MainGame.settlementStats.hasCrafting() || MainGame.settlementStats.isCraftingBeingBuilt()) {
					if(MainGame.settlementStats.hasCrafting()) {
						System.out.println("\n< You Already Have A Crafting Building!");
					}else if(MainGame.settlementStats.isCraftingBeingBuilt()) {
						System.out.println("\n< You Are Already Building A Crafting Building!");
					}

					Thread.sleep(1500);
					Misc.clearConsole();
					CreateBuilding();
					break;
				}
				
				if(MainGame.playerStats.getWood() >= 50 &&
				   MainGame.settlers.size() > 2) {
				
					if(MainGame.settlers.size() <= 2) {
						System.out.println("\n< You Need Atleast 2 Settlers To Build A Crafting Building (Requires 1 To Build And 1 Normal Settler)");
						Thread.sleep(1500);
						Misc.clearConsole();
						CreateBuilding();
					}else {
						successfulChoice = ChooseBuilders(4);
					}
				}else {
					System.out.println("\n< You Don't Have The Required Resources\n");
					if(MainGame.playerStats.getMetal() <= 1) {
						System.out.println("> Not Enough Metal!");
					}
					if(MainGame.playerStats.getWood() <= 1) {
						System.out.println("> Not Enough Wood!");
					}
					if(MainGame.settlers.size() <= 2) {
						System.out.println("> Not Enough Settlers!\n");
					}
					//Tell Them Which Resources They Dont Have
					Thread.sleep(1500);
					Misc.clearConsole();
					CreateBuilding();
				}
				
				if(successfulChoice) {
					MainGame.settlementStats.setDayOverStatus(true);
				}else if(!successfulChoice) {
					BuildingMenu();
				}

				break;
			case 5:
				if(MainGame.settlementStats.hasWaterPump() || MainGame.settlementStats.isWaterPumpBeingBuilt()) {
					if(MainGame.settlementStats.hasWaterPump()) {
						System.out.println("\n< You Already Have A Water Pump!");
					}else if(MainGame.settlementStats.isWaterPumpBeingBuilt()) {
						System.out.println("\n< You Are Already Building A Water Pump!");
					}

					Thread.sleep(1500);
					Misc.clearConsole();
					CreateBuilding();
					break;
				}
				
				if(MainGame.playerStats.getMetal() >= 30 &&
				   MainGame.settlers.size() > 2 &&
				   MainGame.settlementStats.hasCrafting()) {
				
					if(MainGame.settlers.size() <= 2) {
						System.out.println("\n< You Need Atleast 2 Settlers To Build A Water Pump (Requires 1 To Build And 1 Normal Settler)");
						Thread.sleep(1500);
						Misc.clearConsole();
						CreateBuilding();
					}else {
						successfulChoice = ChooseBuilders(5);
					}
				}else {
					System.out.println("\n< You Don't Have The Required Resources\n");
					if(MainGame.playerStats.getMetal() <= 1) {
						System.out.println("> Not Enough Metal!");
					}
					if(MainGame.playerStats.getWood() <= 1) {
						System.out.println("> Not Enough Wood!");
					}
					if(MainGame.settlers.size() <= 2) {
						System.out.println("> Not Enough Settlers!\n");
					}
					//Tell Them Which Resources They Dont Have
					Thread.sleep(1500);
					Misc.clearConsole();
					CreateBuilding();
				}
				
				if(successfulChoice) {
					MainGame.settlementStats.setDayOverStatus(true);
				}else if(!successfulChoice) {
					BuildingMenu();
				}

				break;
			case 6:
				BuildingMenu();
				break;
			default:
				MainGame.settlementStats.setDayOverStatus(true);
				break;
		}	
	}
	
	private static boolean ChooseBuilders(int buildId) throws InterruptedException {
		boolean limit = false;
		int choice = 0, currentBuilders = 0;
		String buildName;
		
		buildName = GetBuildName(buildId);
		
		do {				
			int builders = MainGame.builders.size();
			currentBuilders = 0; //Reset
			for(int i = 0; i < builders; i++) {
				if(MainGame.builders.get(i).getBuildId() == buildId) {
					currentBuilders++;
				}				
			}
			
			if(buildId == 1 && currentBuilders == 3) {
				limit = true;
				break;
			}
			if(buildId == 2 && currentBuilders == 3) {
				limit = true;
				break;
			}
			if((buildId == 3 || buildId == 4 || buildId == 5) && currentBuilders == 1) {
				limit = true;
				break;
			}
			
			
			System.out.println("\n< Who Do You Want To Use As A Builder? (-1 to Cancel)");
			System.out.println("============================================");
			System.out.println("\n< Current Settlers: \n");
			int id = 1;
			for(Settler settler : MainGame.settlers) {
				if(settler.getAge() >= 20 && settler.getAge() <= 60) {
					System.out.println(id + ") Name:  " + settler.getFirstName() + " " + settler.getLastName());
					System.out.println("   Health: " + settler.getHealth());
				}
				++id;
			}
			System.out.println("============================================");
			System.out.println("\n< Chosen Builders: \n");
			if(currentBuilders == 0) {
				System.out.println("<  No-one Has Been Chosen Yet..");
			}else {
				id = 1;
				for(Settler builder : MainGame.builders) {	
					if(builder.getBuildId() == buildId) {
						System.out.println(id + ") Name:  " + builder.getFirstName() + " " + builder.getLastName());
						System.out.println("   Health: " + builder.getHealth());
						//Could Print Out Perks When Done
					}
					++id;
				}	
			}
			System.out.println("============================================");
			
			System.out.println("\n< Choose between (1 -> " + MainGame.settlers.size() + ") (-1 To Cancel)");
			choice = InputHandling.Integer(-1, MainGame.settlers.size());
			
			if(choice == -1) {
				
				while(MainGame.builders.size() != 0) {
					for(int i = 0; i < MainGame.builders.size(); i++) {
						if(MainGame.builders.get(i).getBuildId() == buildId) {
							Settler removed = MainGame.builders.remove(i);
							removed.setBuilding(false);
							MainGame.settlers.add(removed);
							break;
						}				
					}
				}
				
				System.out.println("\n< Returning To Build Menu!");
				break;
			}
			
			System.out.println("\n< " + MainGame.settlers.get(choice-1).getFirstName() + " Has Been Set To Build The " + buildName +"!");
			
			Settler removed = MainGame.settlers.remove(choice-1);
			removed.setBuildId(buildId);
			MainGame.builders.add(removed);
			
		}while(choice != 0 || limit == true);
		
		if(choice != -1) {
			System.out.println("\n< " + buildName + " Is Being Built By:");
			System.out.println("\n============================================\n");
			int id = 1;
			for(Settler builder : MainGame.builders) {	
				if(builder.getBuildId() == buildId) {
					System.out.println(id + ") Name:  " + builder.getFirstName() + " " + builder.getLastName());
					System.out.println("   Health: " + builder.getHealth());
					builder.setBuilding(true);
					//Could Print Out Perks When Done
				}
				++id;
			}	
			System.out.println("\n============================================");		
			Thread.sleep(1000);
			
			Build building = createBuildObject(buildId, buildName);
			removeResources(buildId);
			
			System.out.println("\n< Your " + buildName + " Will Be Built In " + building.getEndBuild() + " Days");
			Thread.sleep(1000);	
			return true;
		}
		
		return false;

		
	}
	
	public static void removeResources(int buildId) {
		if(buildId == 1) {
		    MainGame.playerStats.setMetal(MainGame.playerStats.getMetal() - 250);
		    MainGame.playerStats.setWood(MainGame.playerStats.getWood() - 100);
		}if(buildId == 2) {
		    MainGame.playerStats.setWood(MainGame.playerStats.getWood() - 150);
		}if(buildId == 3) {
			MainGame.playerStats.setMetal(MainGame.playerStats.getMetal() - 100);
		}if(buildId == 4) {
		    MainGame.playerStats.setWood(MainGame.playerStats.getWood() - 50);
		}if(buildId == 5) {
			MainGame.playerStats.setMetal(MainGame.playerStats.getMetal() - 30);
		}
	}
	
	public static void ReturnBuilders(int buildId) {
		Build building = findBuilding(buildId);
		
	    building.setEndBuild(0);
		building.setBuildDays(0);
	    
		if(buildId == 1) {
			MainGame.settlementStats.setBunkerBeingBuilt(false);
			MainGame.settlementStats.setHasBunker(true);
		}if(buildId == 2) {
			MainGame.settlementStats.setFarmBeingBuilt(false);
			MainGame.settlementStats.setHasFarm(true);
		}if(buildId == 3) {
			MainGame.settlementStats.setForgeBeingBuilt(false);
			MainGame.settlementStats.setHasForge(true);
		}if(buildId == 4) {
			MainGame.settlementStats.setCraftingBeingBuilt(false);
			MainGame.settlementStats.setHasCrafting(true);
		}if(buildId == 5) {
		    MainGame.settlementStats.setWaterPumpBeingBuilt(false);
		    MainGame.settlementStats.setHasWaterPump(true);
		}
		
		while(MainGame.builders.size() != 0) {
			for(int i = 0; i < MainGame.builders.size(); i++) {
				if(MainGame.builders.get(i).getBuildId() == buildId) {
					Settler removed = MainGame.builders.remove(i);
					removed.setBuilding(false);
					MainGame.settlers.add(removed);
					break;
				}				
			}
		}
		
		for(int i = 0; i < SettlementManagement.builds.size(); i++) {
			if(SettlementManagement.builds.get(i).getBuildId() == buildId) {
				SettlementManagement.builds.remove(i);
			}
		}		
		
	}
	
	public static Build createBuildObject(int buildId, String buildName) {
		
	    Build building = new Build();
	    building.setBuildId(buildId);
	    building.setBuildName(buildName);
	    building.setBuildDays(0);

		if(buildId == 1) {
		    building.setEndBuild(3);
			MainGame.settlementStats.setBunkerBeingBuilt(true);
		}if(buildId == 2) {
		    building.setEndBuild(2);
			MainGame.settlementStats.setFarmBeingBuilt(true);
		}if(buildId == 3) {
		    building.setEndBuild(2);
			MainGame.settlementStats.setForgeBeingBuilt(true);
		}if(buildId == 4) {
		    building.setEndBuild(2);
			MainGame.settlementStats.setCraftingBeingBuilt(true);
		}if(buildId == 5) {
		    building.setEndBuild(2);
			MainGame.settlementStats.setWaterPumpBeingBuilt(true);
		}
		
	    SettlementManagement.builds.add(building);
	    
	    return building;
	}
	
	public static Build findBuilding(int buildId) {
		for(Build building : SettlementManagement.builds) {
			if(building.getBuildId() == buildId) {
				return building;
			}
		}
		
		return null;	
	}
	
	public static String GetBuildName(int buildId) {
		if(buildId == 1) {
			return "Bunker";
		}if(buildId == 2) {
			return "Farm";
		}if(buildId == 3) {
			return "Forge";
		}if(buildId == 4) {
			return "Crafting Building";
		}if(buildId == 5) {
			return "Water Pump";
		}
		
		return "???Unknown Building???";
	}

	
}
