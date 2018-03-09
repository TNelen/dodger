package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

	public Player(int x, int y, String type) {
		super(x, y, type);
		
		//velX =5;
		//velY =5;
	}

	
	public void tick() {
		x +=velX;
		y +=velY;
	}

	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}

}
