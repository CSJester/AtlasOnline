import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MapPanel extends JPanel {

	private BufferedImage map;
	private Player user;
	private ArrayList<Player> players;
	
	public MapPanel() {
		try {
			map = ImageIO.read(getClass().getResource("/resources/MapGraphic.jpg"));
		}
		catch (IOException e) {
			System.out.println("graphic did not load, IOException:");
			e.printStackTrace();
		}
		players = new ArrayList<Player>();
	}
	
	public void setUser(Player p) {
		user = p;
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	    g.drawImage(map, 0, 0, this);
	    if (players != null) {
	    	for (Player p: players) {
	    		g.setColor(Color.RED);
	    		g.fillOval(p.getX(), p.getY(), 10, 10);
	    		g.setColor(Color.BLACK);
	    		g.drawOval(p.getX(), p.getY(), 10, 10);
	    	}
	    }
	    if (user != null) {
	    	g.setColor(Color.GREEN);
	    	g.fillOval(user.getX(), user.getY(), 10, 10);
	    	g.setColor(Color.BLACK);
	    	g.drawOval(user.getX(), user.getY(), 10, 10);
	    }
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(600, 450);
	}
	
}
