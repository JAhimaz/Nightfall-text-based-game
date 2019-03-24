package com.nightfall.scavenging;

import com.nightfall.main.MainGame;

public class ScavengingCalls {

	public static void ScavengingCall() throws InterruptedException{
		if(MainGame.settlementStats.isScavenging() && MainGame.settlementStats.getScavengingDays() == MainGame.settlementStats.getEndScavenging()) {
			Scavenging.ReturnScavengers();
			Thread.sleep(3000);
		}
		else if(MainGame.settlementStats.isScavenging()) {
			MainGame.settlementStats.incrementScaveningDays();
			if(MainGame.settlementStats.getScavengingDays() > 0) {
				System.out.println("\n< Your Scavengers Will Return in " + (((MainGame.settlementStats.getEndScavenging() - MainGame.settlementStats.getScavengingDays())) + 1) + " Days");
			}
		}
	}
}
