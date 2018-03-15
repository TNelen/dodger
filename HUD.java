package SoftwareProject.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	private int x, y, health=100, opacity=180;
	
	
	public HUD(int x) {
		y = 50;
		this.x=x;
	}


	public void setHealth(int hp) {
		health = hp;
	}


	public void render(Graphics g) {
		g.setColor(new Color(255,255,255,opacity));
		g.fillRect(x-3, y-3, 206, 26);
		g.setColor(new Color(244,0,0,opacity));
		g.fillRect(x, y, 200, 20);
		g.setColor(new Color(0,255,0,opacity));
		g.fillRect(x, y, health*2, 20);
		g.setFont(new Font("Helvetica", Font.BOLD, 15)); 
		g.setColor(Color.black);
		g.drawString(health+"%", x+2, y+15);
	}
	
	
}