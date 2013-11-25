import java.util.ArrayList;


public class Nation {

	private String name;
	private ArrayList<Player> citizens;
	private ArrayList<Player> ministers;
	private Player leader;
	private String type;
	
	public Nation(String aName, String aType, Player aLeader) {
		name = aName;
		leader = aLeader;
		type = aType;
		citizens = new ArrayList<Player>();
		if (type.equals("Democracy")) {
			ministers = new ArrayList<Player>();
		}
	}
	
	public void addCitizen(Player player){
		citizens.add(player);
	}
	
	public String getName() {
		return name;
	}
	
}
