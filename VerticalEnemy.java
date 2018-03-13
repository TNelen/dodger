package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class VerticalEnemy extends GameObject {

	
	
	public VerticalEnemy(int x, int y) {
		super(x, y , "Vertical");
		
		velX = 2;
		velY = 5;
	}
	
	public void tick() {
		x += velX;
		y += velY;
		if(y <= 0 || y>= Game.HEIGHT - 32)	velY *= -1;  //keert terug als rand van scherm raakt
		if(x <= 0 || x>= Game.WIDTH - 720)	velX *= -1;  //keert terug als rand van scherm raakt
	}
	
	public void render(Graphics g) { 
		g.setColor(Color.gray);
		g.fillRect(x,y,720,25);
	}

	
	public Rectangle getBounds() {
		return new Rectangle(x,y,720,25);
	}


}
