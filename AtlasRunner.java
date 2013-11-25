
public class AtlasRunner {
	public static void main(String[] args) {
		Territory origin = new Territory("Origin", Terrain.Farmland, Resource.Food);
		Territory south = new Territory("SouthMount",Terrain.Mountain, Resource.Metal);
		Territory sampo = new Territory("Sampo River",Terrain.River, Resource.Water);
		Territory quarry = new Territory("High Quarry",Terrain.Quarry, Resource.Stone);
		Territory plateau = new Territory("Plateau",Terrain.Farmland, Resource.Food);
		Territory x = new Territory("Mount Xeroxin",Terrain.Mountain, Resource.Metal);
		Territory cape = new Territory("Cape Crush",Terrain.River, Resource.Water);
		AtlasMap.connect(south, origin);
		AtlasMap.connect(south, sampo);
		AtlasMap.connect(sampo, quarry);
		AtlasMap.connect(quarry, origin);
		AtlasMap.connect(origin, plateau);
		AtlasMap.connect(plateau, x);
		AtlasMap.connect(x, cape);
		AtlasMap.connect(cape, plateau);
		
		AtlasMap map = new AtlasMap("World");
		map.addTerritory(origin);
		map.addTerritory(south);
		map.addTerritory(sampo);
		map.addTerritory(quarry);
		map.addTerritory(plateau);
		map.addTerritory(x);
		map.addTerritory(cape);
		
		Player player = new Player(origin);
		
		player.travel(quarry);
		System.out.println("attempted move to quarry\n now in: "+player.isOn().getName());
	}
}
