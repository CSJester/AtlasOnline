import java.util.Scanner;


public class Player {

	private String name;
	
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
	private Terrain ground;
	
	
	public Player(String name) {
		Scanner in = new Scanner(System.in);
		this.name = name;
		System.out.println("Player: "+name);
		ground = new Terrain();
		points = 100;
		
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
		System.out.println("Assign points to goal attributes: \nP: Privacy\nW: Wealth\nE: Environment\nO: Power\nK: Knowledge");
		while (points > 0) {
			System.out.println("5 points to: ");
			String input = in.next();
			if ((input.equalsIgnoreCase("P")) && (PrivacyGoal<=20)) {
				PrivacyGoal += 5;
				points -= 5;
			}else if ((input.equalsIgnoreCase("W")) && (WealthGoal<=20)) {
				WealthGoal += 5;
				points -= 5;
			}else if ((input.equalsIgnoreCase("E")) && (EnvironmentGoal<=20)) {
				EnvironmentGoal += 5;
				points -= 5;
			}else if ((input.equalsIgnoreCase("O")) && (PowerGoal<=45)) {
				PowerGoal += 5;
				points -= 5;
			}else if ((input.equalsIgnoreCase("K")) && (KnowledgeGoal <= 45)) {
				KnowledgeGoal += 5;
				points -= 5;
			}else {
				System.out.println("Please enter a valid option");
			}
			System.out.println("\nRemaining Points: "+points);
			printGoals();
		}
		System.out.println("Out of goal points, time to play!");
		in.close();
	}
	
	public void printGoals() {
		System.out.println("PrivacyGoal: "+ PrivacyGoal);
		System.out.println("WealthGoal: "+ WealthGoal);
		System.out.println("EnvironmentGoal: "+ EnvironmentGoal);
		System.out.println("PowerGoal: "+ PowerGoal);
		System.out.println("KnowledgeGoal: "+ KnowledgeGoal);
	}
}
