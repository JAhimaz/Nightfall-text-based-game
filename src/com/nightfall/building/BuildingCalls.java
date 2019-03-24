package com.nightfall.building;

import com.nightfall.main.MainGame;
import com.nightfall.npc.Settler;
import com.nightfall.settlement.SettlementManagement;

public class BuildingCalls {
	
	public static void BuildingCall() throws InterruptedException{
		
		for (Settler builders : MainGame.builders) {

		}
	
		for (int i = 0; i < SettlementManagement.builds.size(); i++) {
			Build building = SettlementManagement.builds.get(i);
			
			if(building.getBuildId() == 1) {
				if((building.getBuildDays() == building.getEndBuild()) && MainGame.settlementStats.isBunkerBeingBuilt()) {
					System.out.println("\n< Your " + building.getBuildName() + " Is Complete!");
					Thread.sleep(1000);
					Building.ReturnBuilders(building.getBuildId());
				}else if(MainGame.settlementStats.isBunkerBeingBuilt()) {
					building.incrementBuildDay();
					if(building.getBuildDays() > 0) {
						System.out.println("\n< Your " + building.getBuildName() + " Will Be Complete In " + (((building.getEndBuild() - building.getBuildDays())) + 1) + " Days");
					}
				}
			}
			
			if(building.getBuildId() == 2) {
				if((building.getBuildDays() == building.getEndBuild()) && MainGame.settlementStats.isFarmBeingBuilt()) {
					System.out.println("\n< Your " + building.getBuildName() + " Is Complete!");
					Thread.sleep(1000);
					Building.ReturnBuilders(building.getBuildId());
				}else if(MainGame.settlementStats.isFarmBeingBuilt()) {
					building.incrementBuildDay();
					if(building.getBuildDays() > 0) {
						System.out.println("\n< Your " + building.getBuildName() + " Will Be Complete In " + (((building.getEndBuild() - building.getBuildDays())) + 1) + " Days");
					}
				}
			}
			
			if(building.getBuildId() == 3) {
				if((building.getBuildDays() == building.getEndBuild()) && MainGame.settlementStats.isForgeBeingBuilt()) {
					System.out.println("\n< Your " + building.getBuildName() + " Is Complete!");
					Thread.sleep(1000);
					Building.ReturnBuilders(building.getBuildId());
				}else if(MainGame.settlementStats.isForgeBeingBuilt()) {
					building.incrementBuildDay();
					if(building.getBuildDays() > 0) {
						System.out.println("\n< Your " + building.getBuildName() + " Will Be Complete In " + (((building.getEndBuild() - building.getBuildDays())) + 1) + " Days");
					}
				}
			}
			
			if(building.getBuildId() == 4) {
				if((building.getBuildDays() == building.getEndBuild()) && MainGame.settlementStats.isCraftingBeingBuilt()) {
					System.out.println("\n< Your " + building.getBuildName() + " Is Complete!");
					Thread.sleep(1000);
					Building.ReturnBuilders(building.getBuildId());
				}else if(MainGame.settlementStats.isCraftingBeingBuilt()) {
					building.incrementBuildDay();
					if(building.getBuildDays() > 0) {
						System.out.println("\n< Your " + building.getBuildName() + " Will Be Complete In " + (((building.getEndBuild() - building.getBuildDays())) + 1) + " Days");
					}
				}
			}
			
			if(building.getBuildId() == 5) {
				if((building.getBuildDays() == building.getEndBuild()) && MainGame.settlementStats.isWaterPumpBeingBuilt()) {
					System.out.println("\n< Your " + building.getBuildName() + " Is Complete!");
					Thread.sleep(1000);
					Building.ReturnBuilders(building.getBuildId());
				}else if(MainGame.settlementStats.isWaterPumpBeingBuilt()) {
					building.incrementBuildDay();
					if(building.getBuildDays() > 0) {
						System.out.println("\n< Your " + building.getBuildName() + " Will Be Complete In " + (((building.getEndBuild() - building.getBuildDays())) + 1) + " Days");
					}
				}
			}
	
		}
		
	}
}
