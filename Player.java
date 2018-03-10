package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

	Handler handler;
	int health;
	int hudX;


	public Player(int x, int y, String type, Handler handler, int health, int hudX) {
		super(x, y, type);
		this.handler = handler;
		this.health = health;
		this.hudX = hudX;

		
		//velX =5;
		//velY =5;
	}

	
	public void tick() {
		x +=velX;
		y +=velY;
		// je kan niet buiten de grenzen van het spel
		x = Game.border(x, 0, Game.WIDTH-37); //als je volgende x positie buiten veld is, dan terug naar vorige x positie
		y = Game.border(y, 0, Game.HEIGHT-60); // idem x
	}

	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 32, 32);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,32,32);
	}
	
	public void setHealth(int hp) {
		health = hp;
	}
	
	public int getHealth() {
		return health;
	}
	
	
	/*
	public void updateHud(health) {
		// nog aanvullen
	} */

}
