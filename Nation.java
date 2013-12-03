import java.util.ArrayList;


public class Nation {

	private String name;
	private ArrayList<Player> members;
	private Territory territory;
	
	public Nation(String aName, Territory ter) {
		name = aName;
		members = new ArrayList<Player>();
		territory = ter;
		territory.setNation(this);
	}
	
	public void addMember(Player player) {
		members.add(player);
		player.setNation(this);
	}
	
	public void removeMember(Player player) {
		members.remove(player);
	}
	
	public String getName() {
		return name;
	}
	
}
