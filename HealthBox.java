package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class HealthBox extends GameObject {

	Random r = new Random();
	
	public HealthBox(int x, int y, String type) {
		super(x, y, type);
		
	}

	@Override
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x,y,16,16);
		g.setColor(Color.red);
		g.fillRect(x+7,y,2,16);
		g.fillRect(x,y+8,16,2);
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}

}
