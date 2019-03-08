package NightfallPackage;

public class PlayerStats {
	private int metal,
			   	wood,
			   	weapons,
			   	food,
			   	water;
	private boolean playerDead = false;

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
}
