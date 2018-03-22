package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BlobEnemy extends GameObject{
	
	int breedte,lengte, plusMin=1;
	
	public BlobEnemy() {
		super("Blob");
		Random r = new Random();
		velX=(r.nextInt(5)+3)*(r.nextBoolean() ? -1 : 1);
		velY=(r.nextInt(4)+3)*(r.nextBoolean() ? -1 : 1);
		
		breedte=25;
		lengte=25;
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		
		if(x<Game.WIDTH-breedte-5 && y <Game.HEIGHT-lengte-20) {		//Mag niet breder/langer worden als hij rand gaat raken
			lengte+=plusMin;
			if(lengte == 125 || lengte == 25) {				
				plusMin *= -1;
			}
			breedte = 150-lengte;
		}
		
			if(y <= 0 || y>= Game.HEIGHT-lengte-15)	velY *= -1;  //keert terug als rand van scherm raakt
			if(x <= 0 || x>= Game.WIDTH-breedte)	velX *= -1;  //keert terug als rand van scherm raakt
	}
	
	public void render(Graphics g) { 
		g.setColor(Color.yellow);
		g.fillRect(x,y,breedte,lengte);
	}

	
	public Rectangle getBounds() {
		return new Rectangle(x,y,breedte,lengte);
	}
	
}
