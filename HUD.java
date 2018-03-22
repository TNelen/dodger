package SoftwareProject.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	private int x, y, health=100, opacity=180;					//Standaard is de health 100, en is de levensbalk een beetje doorzichtig
	
	
	public HUD(int x) {
		y = 50;
		this.x=x;												//De x-positie van een hud hangt af van de betreffende speler
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
		g.setFont(new Font("Helvetica", Font.BOLD, 15)); 		//De healthbar wordt getekend
		g.setColor(Color.black);
		g.drawString(health+"%", x+2, y+15);					
	}
	
	
}