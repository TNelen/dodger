package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class VerticalEnemy extends GameObject {

	
	
	public VerticalEnemy(int x, int y, int velX, int velY) {
		super(x, y , "vertical");
		
		this.velX = velX;			//Deze constructor kan gebruikt worden als op voorhand een vaste velocity geset moet worden, als ook de positie
		this.velY = velY;
	}
	
	public void tick() {
		x += velX;
		y += velY;
		if(y <= 0 || y>= Game.HEIGHT - 32)	velY *= -1;  //keert terug als rand van scherm raakt
		if(x <= 0 || x>= Game.WIDTH - 16)	velX *= -1;  //keert terug als rand van scherm raakt
	}
	
	public void render(Graphics g) { 
		g.setColor(Color.gray);
		g.fillRect(x,y,100,25);
	}

	
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}


}
