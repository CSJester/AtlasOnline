import java.util.ArrayList;


public class Territory {
	
	private ArrayList<Territory> adjacents;
	private ArrayList<Player> players;
	private String name;
	private Terrain terrain;
	private Resource resource;
	
	public Territory(String name, Terrain ter, Resource res) {
		this.name = name;
		terrain = ter;
		resource = res;
		adjacents = new ArrayList<Territory>();
		players = new ArrayList<Player>();
	}
	
	public void addAdjacent(Territory adj) {
		adjacents.add(adj);
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void removePlayer(Player player) {
		players.remove(player);
	}
	
	public ArrayList<Territory> getAdjacents() {
		return adjacents;
	}
	
	public String getName() {
		return name;
	}
	
	public Terrain getTerrain() {
		return terrain;
	}
	
	public Resource getResource() {
		return resource;
	}
	
}
