package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	private int x, y, health=100;
	
	
	public HUD(int x) {
		y = 100;
		this.x=x;
	}


	public void setHealth(int hp) {
		health = hp;
	}


	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x-3, y-3, 206, 26);
		g.setColor(Color.green);
		g.fillRect(x, y, health*2, 20);
		g.setColor(Color.white);
		g.drawString(health+"%", x, y-10);
	}
	
	
}
