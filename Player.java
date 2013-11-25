import java.util.Scanner;


public class Player {

	private String name;
	
	private int Metal;
	private int Wood;
	private int Food;
	private int Water;
	private int Stone;
	
	private int Privacy;
	private int Wealth;
	private int Environment;
	private int Power;
	private int Knowledge;
	
	private int PrivacyGoal;
	private int WealthGoal;
	private int EnvironmentGoal;
	private int PowerGoal;
	private int KnowledgeGoal;
	
	private int points;
	private Territory ground;
	private String status;
	private boolean create;
	private int x;
	private int y;
	//private Nation nation;
	
	
	
	public Player() {
		//Scanner in = new Scanner(System.in);
		create = true;
		//System.out.println("Player: "+name);
		points = 100;
		status = "Creating";
		
		Privacy = 100;
		Wealth = 0;
		Environment = 0;
		Power = 0;
		Knowledge = 0;
		
		PrivacyGoal = 0;
		WealthGoal = 0;
		EnvironmentGoal = 0;
		PowerGoal = 0;
		KnowledgeGoal = 0;
		//System.out.println("Assign points to goal attributes: \nP: Privacy\nW: Wealth\nE: Environment\nO: Power\nK: Knowledge\n");
		//while (points > 0) {
			//System.out.println("5 points to: ");
			//String input = in.next();
			//if (input.equalsIgnoreCase("P")) {
				//addHPPrivacy();
			//}else if (input.equalsIgnoreCase("W")) {
				//addHPWealth();
			//}else if (input.equalsIgnoreCase("E")) {
				//addHPEnvironment();
			//}else if (input.equalsIgnoreCase("O")) {
				//addHPPower();
			//}else if (input.equalsIgnoreCase("K")) {
				//addHPKnowledge();
			//}else {
				//System.out.println("Please enter a valid option");
			//}
			//System.out.println("\nRemaining Points: "+points);
			//printGoals();
		//}
		//System.out.println("Out of goal points, time to play!");
		//in.close();
	}
	
	public void addHPPower() {
		if (PowerGoal<=45) {
			PowerGoal += 5;
			points -= 5;
		}
	}
	public void addHPEnvironment() {
		if (EnvironmentGoal<=20) {
			EnvironmentGoal += 5;
			points -= 5;
		}
	}
	public void addHPPrivacy() {
		if (PrivacyGoal<=20) {
			PrivacyGoal += 5;
			points -= 5;
		}
	}
	public void addHPKnowledge() {
		if (KnowledgeGoal <= 45) {
			KnowledgeGoal += 5;
			points -= 5;
		}
	}
	public void addHPWealth() {
		if (WealthGoal<=20) {
			WealthGoal += 5;
			points -= 5;
		}
	}
	
	public void printGoals() {
		System.out.println("PrivacyGoal: "+ PrivacyGoal);
		System.out.println("WealthGoal: "+ WealthGoal);
		System.out.println("EnvironmentGoal: "+ EnvironmentGoal);
		System.out.println("PowerGoal: "+ PowerGoal);
		System.out.println("KnowledgeGoal: "+ KnowledgeGoal);
	}
	
	public String getName() {
		return name;
	}
	
	public void addResource(int amount, Resource res) {
		String r = res.toString();
		if (amount <= 0) {
			System.out.println("Cannot add negative resources");
			return;
		}
		if (r.equals("Metal")) {
			Metal += amount;
			return;
		}if (r.equals("Wood")) {
			Wood += amount;
			return;
		}if (r.equals("Food")) {
			Food += amount;
			return;
		}if (r.equals("Water")) {
			Water += amount;
			return;
		}if (r.equals("Stone")) {
			Stone += amount;
			return;
		}
	}
	
	public Territory isOn() {
		return ground;
	}
	
	public void travel(Territory ter) {
		isOn().removePlayer(this);
		ter.addPlayer(this);
		setGround(ter);
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public int getWealth() {
		return Wealth;
	}
	public int getPrivacy() {
		return Privacy;
	}
	public int getPower() {
		return Power;
	}
	public int getEnvironment() {
		return Environment;
	}
	public int getKnowledge() {
		return Knowledge;
	}
	
	public int getKnGoal() {
		return KnowledgeGoal;
	}
	public int getPrGoal() {
		return PrivacyGoal;
	}
	public int getPoGoal() {
		return PowerGoal;
	}
	public int getEnGoal() {
		return EnvironmentGoal;
	}
	public int getWeGoal() {
		return WealthGoal;
	}
	
	public void setGround(Territory origin) {
		ground = origin;
		ground.addPlayer(this);
		x = ground.getX() - 15 + (int)(Math.random()*30);
		y = ground.getY() - 15 + (int)(Math.random()*30);
		checkReady();
	}
	
	public Territory getGround() {
		return ground;
	}
	
	public void checkReady() {
		if ((points==0) && (ground != null) && (name != null)) {
			status = "Nomad";
		}
	}
	
	public String getStatus() {
		return status;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
