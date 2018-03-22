package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Player extends GameObject {

	Handler handler;
	int health;
	int hudX;
	Color col;
	HUD hud;


	public Player(int x, int y, String type, Handler handler, int hudX, Color c) {
		super(x, y, type);
		this.handler = handler;
		this.hudX = hudX;
		health=100;
		hud = new HUD(hudX);		//Welke kleur, waar moet de HUD,..
		col = c;
	}

	
	public void tick() {
		x +=velX;
		y +=velY;
														//Player kan niet buiten de grenzen van het spel
		x = Game.border(x, 0, Game.WIDTH-37); 			//Als de volgende x positie buiten het veld ligt, keert speler terug naar vorige x positie
		y = Game.border(y, 0, Game.HEIGHT-60); 			//Zelfde voor y
		collisionCheck();
		if(health<=0) {
			health = 0;
			if(type.equals("Player1")){
				handler.setWinner("Player 2");
			}else{
				handler.setWinner("Player 1");			//Winnaar verkiezen als een player doodgaat
			}
			handler.setGameOver(true);
		}
	}

	
	public void render(Graphics g) {
		g.setColor(col);
		g.fillRect(x, y, 32, 32);
		updateHud(g);					//Health doorgeven aan hud
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,32,32);
	}
	
	public void setHealth(int hp) {
		health = hp;
		
	}
	
	public void reset(){
		
		health=100;
		if(type.equals("Player1")){
			x=400;y=400;
		}else{
			x=960;y=400;				//Speler terug op basispositie
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public void collisionCheck() {
		LinkedList<GameObject> list = handler.getObjects();
		for(int i =2;i<list.size();i++) {
			GameObject tempObject = list.get(i);
			if(getBounds().intersects(tempObject.getBounds())){
				switch(tempObject.getType()) {
						case "Enemy": health-=4;
							break;
						case "HealthBox": 
							if(health<81) {
								health+=20;
							}else {
								health=100;
							}
							handler.removeObject(tempObject);		//Vergelijkt de positie van de player met de andere objecten
							break;									//Bij collision wordt health afgenomen naargelang het soort enemy
						case "Vertical": health -=5;
							break;
						case "Following": health -=2;
							break;
						case "Blob":health -=2;
							break;
						case "EnemyLine":health -=4;
						break;
						case "EnemyLine1":health -=4;
						break;
						case "EnemyLine2":health -=4;
						break;
				}
			}
		}
	}
	
	public void updateHud(Graphics g) {
		hud.setHealth(health);
		hud.render(g);
	}

}
