package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Spawn{

	Handler handler;
	int score, counter;
	Random x = new Random();
	Random y = new Random();
	
	public Spawn(Handler h) {
		handler=h;
		
	}
	
	public void tick() {
		score++;
		checkSpawn();
	}

	private void checkSpawn() {
		switch(score) {
		
		case 1: handler.addObject(new Player(100 ,100, "player1", handler, 100, 200));
				handler.addObject(new Player(500 ,500, "player2", handler, 100, 1000));
				break;
		case 200: handler.addObject(new Enemy(x.nextInt(1400)+10, y.nextInt(800)+10, "Enemy", handler));
				break;
				
		case 400: handler.addObject(new Enemy(x.nextInt(1400)+10, y.nextInt(800)+10, "Enemy", handler));
				break;
		default:
				break;
			
			
			
		
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawString("Score: "+score, 50, 50);
	}
	
}
