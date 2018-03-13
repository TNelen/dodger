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
		if(Math.floorMod(score, 500)==0) {
			removeAllType("HealthBox");
			handler.addObject(new HealthBox());	//Een healthbox om de 500 score, de vorige verdwijnt
		}
		
		switch(score) {
		
		case 1: handler.addObject(new Player(400 ,400, "Player1", handler, 200,Color.yellow));
				handler.addObject(new Player(960 ,400, "Player2", handler, 1000,Color.CYAN));
				//handler.addPlayer();
				break;
				
		case 5: handler.addObject(new FollowingEnemy(50, 50, "Following", handler, "Player1"));
				handler.addObject(new FollowingEnemy(50, 50, "Following", handler, "Player2"));
				break;
		
		case 100: handler.addObject(new Enemy());
				break;
				
		case 300: handler.addObject(new Enemy());
				  //handler.addObject(new HealthBox());
				break;
				
		case 350: handler.addObject(new VerticalEnemy(0, 10));
				break;
				
		case 50: handler.addObject(new BlobEnemy());		//Staat vroeg om te testen
				break;
		
		case 818: removeAllType("Vertical");		//Aparte method voor gemaakt, dan moeten we geen 100 loops schrijven
				break;
		case 1000:
				for(int i=0;i< 10 ; i++) {
					handler.addObject(new Enemy(5,i*80,4,0, "EnemyLine"));
				}
				break;
				
		case 1715:
			
			for(int j=0; j<10 ; j++) {
				removeAllType("EnemyLine");		//Werkt, maar waarom 10x? (ik zie ook dat 1x niet genoeg is, maar hoe komt da :)
			}
				break;
		case 2500: 
			for(int i=0;i< 20 ; i++) {
				handler.addObject(new Enemy(i*80+25,5,0,4, "EnemyLine"));
			}
				break;
				
		case 2892: 
			for(int j=0; j<20 ; j++) {
				removeAllType("EnemyLine");		//Werkt, maar waarom 10x? (ik zie ook dat 1x niet genoeg is, maar hoe komt da :)
			}
			
				break;
		default:
				break;
			
			
		
		}
}
	
	public int getScore() {
		return score;
	}
	
	public void resetScore() {
		score = 0;
	}
	
	public void removeAllType(String type) {
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i); //loop door alle objecten
					if (tempObject.getType().equals(type)) {
						handler.removeObject(tempObject);
					}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawString("Score: "+score, 50, 50);
	}
	
}
