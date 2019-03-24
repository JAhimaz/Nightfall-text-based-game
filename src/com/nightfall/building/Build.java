package com.nightfall.building;

public class Build {
	private int buildDays, endBuild, 
				buildId; //Build Id Dependent on The Type Of Building and Will Be Assigned To the Builders
	private String buildName;
	

	public int getBuildDays() {
		return buildDays;
	}

	public void setBuildDays(int buildDays) {
		this.buildDays = buildDays;
	}

	public int getEndBuild() {
		return endBuild;
	}

	public void setEndBuild(int endBuild) {
		this.endBuild = endBuild;
	}
	
	public void setBuildId(int id) {
		this.buildId = id;
	}
	
	public int getBuildId() {
		return this.buildId;
	}
	
	public void incrementBuildDay() {
		this.buildDays++;
	}
	
	public void returnBuilders() {
		Building.ReturnBuilders(this.buildId);
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	
}
