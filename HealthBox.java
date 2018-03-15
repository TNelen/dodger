package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HealthBox extends GameObject {

	
	public HealthBox() {
		super("HealthBox");
	}
	
	public HealthBox(int x, int y) {
		super(x, y, "HealthBox");
	}

	@Override
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x,y,32,32);
		g.setColor(Color.red);
		g.fillRect(x+13,y,6,32);
		g.fillRect(x,y+13,32,6);
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}

}
