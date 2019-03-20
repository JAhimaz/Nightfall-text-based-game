package NightfallPackage;

public class PlayerStats {
	private int metal,
			   	wood,
			   	weapons,
			   	food,
			   	water,
				
				daysWithoutFood = 0,
				daysWithoutWater = 0;
	private boolean playerDead = false, foodLess = false, waterLess = false;

	public int getMetal() {
		return metal;
	}

	public void setMetal(int metal) {
		this.metal = metal;
	}

	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public int getWeapons() {
		return weapons;
	}

	public void setWeapons(int weapons) {
		this.weapons = weapons;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public boolean isPlayerDead() {
		return playerDead;
	}

	public void setPlayerStatus(boolean playerDead) {
		this.playerDead = playerDead;
	}

	public boolean isFoodLess() {
		return foodLess;
	}

	public void noFood(boolean foodLess) {
		this.foodLess = foodLess;
	}

	public boolean isWaterLess() {
		return waterLess;
	}

	public void noWater(boolean waterLess) {
		this.waterLess = waterLess;
	}

	public int getDaysWithoutFood() {
		return daysWithoutFood;
	}

	public void setDaysWithoutFood(int daysWithoutFood) {
		this.daysWithoutFood = daysWithoutFood;
	}

	public int getDaysWithoutWater() {
		return daysWithoutWater;
	}

	public void setDaysWithoutWater(int daysWithoutWater) {
		this.daysWithoutWater = daysWithoutWater;
	}
}
