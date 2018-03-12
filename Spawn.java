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
		
		case 1: handler.addObject(new Player(400 ,400, "Player1", handler, 200,Color.yellow));
				handler.addObject(new Player(960 ,400, "Player2", handler, 1000,Color.CYAN));
				//handler.addPlayer();
				break;
		case 100: handler.addObject(new Enemy());
				break;
				
		case 300: handler.addObject(new Enemy());
				  handler.addObject(new HealthBox());
				break;
		case 350: handler.addObject(new VerticalEnemy(0, 10));
				break;
		case 5: handler.addObject(new FollowingEnemy(50, 50, "Following", handler, "Player1"));
				handler.addObject(new FollowingEnemy(50, 50, "Following", handler, "Player2"));
		default:
				break;
			
			
		
		}
	}
	
	public int getScore() {
		return score;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawString("Score: "+score, 50, 50);
	}
	
}
