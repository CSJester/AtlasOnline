import java.util.ArrayList;


public class AtlasMap {
	
	private static ArrayList<Territory> territories;
	private String name;
	
	public AtlasMap(String n)  {
		name = n;
		territories = new ArrayList<Territory>();
	}
	
	public AtlasMap(String n, ArrayList<Territory> ters)  {
		name = n;
		territories = ters;
	}
	
	public void addTerritory(Territory ter) {
		territories.add(ter);
	}
	
	public void removeTerritory(Territory ter) {
		territories.remove(ter);
	}
	
	public ArrayList<Territory> getTerritories() {
		return territories;
	}
	
	public String getName() {
		return name;
	}
	
	public static void connect(Territory t1, Territory t2) {
		t1.addAdjacent(t2);
		t2.addAdjacent(t1);
	}
	
	public Territory randomTer() {
		return territories.get((int)(Math.random()*19));
	}
}
