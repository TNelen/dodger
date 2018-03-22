package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends GameObject {
	
	
	
	public Enemy() {
		
		super("Enemy");
		Random r = new Random();
		x=r.nextInt(1400)+10;
		y=r.nextInt(650)+10;			//In deze constructor wordt een enemy op willekeurige plek, met willekeurige snelheid aangemaakt.
		r = new Random();
		velX=(r.nextInt(5)+3)*(r.nextBoolean() ? -1 : 1);
		velY=(r.nextInt(5)+3)*(r.nextBoolean() ? -1 : 1);
		
		
	}
	
	
	public Enemy(int vel) {
		super("Enemy");
		Random r = new Random();
		x=r.nextInt(1400)+10;
		y=r.nextInt(650)+10;
		
		velX = vel;	//Deze constructor maakt een enemy waarvan de x en y velocity gegeven worden
		velY = vel;
	}
	
	
	
	public Enemy(int x, int y, int velX, int velY, String type) {
		super(x, y , type);
		
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
		g.setColor(Color.red);
		g.fillRect(x,y,25,25);
	}

	
	public Rectangle getBounds() {
		return new Rectangle(x,y,25,25);
	}


}
