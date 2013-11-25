import java.util.ArrayList;


public class Territory {
	
	private ArrayList<Territory> adjacents;
	private ArrayList<Player> players;
	private String name;
	private Terrain terrain;
	private Resource resource;
	private int x;
	private int y;
	private Nation nation;
	
	public Territory(String name, Terrain ter, Resource res, int a, int b) {
		this.name = name;
		terrain = ter;
		resource = res;
		adjacents = new ArrayList<Territory>();
		players = new ArrayList<Player>();
		x = a;
		y = b;
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
	
	public String getTerrain() {
		return terrain.toString();
	}
	
	public String getResource() {
		return resource.toString();
	}
	
	public boolean hasNation() {
		if (nation != null) {
			return true;
		}
		return false;
	}
	
	public Nation getNation() {
		if (hasNation()) {
			return nation;
		}
		return null;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String toString() {
		return name;
	}
	
	public String[] adjStrings() {
		String[] list = new String[adjacents.size()];
		for (int i=0; i<=adjacents.size()-1; i++) {
			list[i] = adjacents.get(i).getName();
		}
		return list;
	}
}
