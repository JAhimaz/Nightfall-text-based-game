package NightfallPackage;

public class SettlementStats {
	//CURRENTPULLEDSTATS
	private int day, scavengingDays, endScavenging;
	//SETTLEMENT DETAILS
	private String settlementName;
	private int settlers,
			    defense,
			    scavengers, scavengerswGuns, scavengerswoGuns;
	//PLAYERSTATE
	private boolean isScavenging = false,
				    marketAttacked = false,
				    dayOver = false;
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void incrementDay() {
		this.day++;
	}
	public int getScavengingDays() {
		return scavengingDays;
	}
	public void setScavengingDays(int scavengingDays) {
		this.scavengingDays = scavengingDays;
	}
	public void incrementScaveningDays() {
		this.scavengingDays++;
	}
	public int getEndScavenging() {
		return endScavenging;
	}
	public void setEndScavenging(int endScavenging) {
		this.endScavenging = endScavenging;
	}
	public String getSettlementName() {
		return settlementName;
	}
	public void setSettlementName(String settlementName) {
		this.settlementName = settlementName;
	}
	public int getSettlers() {
		return settlers;
	}
	public void setSettlers(int settlers) {
		this.settlers = settlers;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getScavengers() {
		return scavengers;
	}
	public void setScavengers(int scavengers) {
		this.scavengers = scavengers;
	}
	public int getScavengerswGuns() {
		return scavengerswGuns;
	}
	public void setScavengerswGuns(int scavengerswGuns) {
		this.scavengerswGuns = scavengerswGuns;
	}
	public int getScavengerswoGuns() {
		return scavengerswoGuns;
	}
	public void setScavengerswoGuns(int scavengerswoGuns) {
		this.scavengerswoGuns = scavengerswoGuns;
	}
	public boolean isScavenging() {
		return isScavenging;
	}
	public void setScavengingStatus(boolean isScavenging) {
		this.isScavenging = isScavenging;
	}
	public boolean isMarketAttacked() {
		return marketAttacked;
	}
	public void setMarketStatus(boolean marketAttacked) {
		this.marketAttacked = marketAttacked;
	}
	public boolean isDayOver() {
		return dayOver;
	}
	public void setDayOverStatus(boolean dayOver) {
		this.dayOver = dayOver;
	}
}
