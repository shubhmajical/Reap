package com.ttnd.reap.user.role;

public enum UserRole {
	user(3,2,1),Supervisor(6,3,2),PracticeHead(9,6,3);
	   private int bronze;
	   private int silver;
	   private int gold;
	   UserRole(int g,int s,int b) {
	      bronze=b;
	      silver=s;
	      gold=g;
	      
	   }
	   
	   public int getBronze() {
		return bronze;
	}
	   public int getGold() {
		return gold;
	}
	   public int getSilver() {
		return silver;
	}
}
