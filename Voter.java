import java.util.ArrayList;
import java.util.Random;


public class Voter {
	
	public static double demoVote(Territory t) {
		ArrayList<Player> ps = t.getPlayers();
		int total = 0;
		int yes = 0;
		double j = 0;
		for (int i=0; i<ps.size();i++) {
			if (ps.get(i).getName().substring(0,2).equals("cp")) {
				j = indVote();
				ps.get(i).vote((int)j);
				yes += j;
				total++;
			}else {
				yes += ps.get(i).getVote();
				total++;
			}
		}
		if (yes >= 6) {
			return ((yes*100.0)/total);
		}else {
			return 0.0;
		}
	}
	public static int indVote() {
		return (int)(Math.round(new Random().nextDouble()));
	}
}
