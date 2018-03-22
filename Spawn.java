package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;

public class Spawn{

	Handler handler;
	int score, counter;
	
	public Spawn(Handler h) {
		handler=h;
		
	}
	
	public void tick() {
		score++;
		checkSpawn();
	}
	

	private void checkSpawn() {
		
		
		if(score>3899) {
			if(score%300==0) {							//Na 3899 blijven enemies continu spawnen
				handler.addObject(new Enemy());
			}
		}else {
			if(score%500==0) {
				removeAllType("HealthBox");
				handler.addObject(new HealthBox());			//Een healthbox om de 500 score, de vorige verdwijnt
			}
			switch(score) {
		
	//WAVE 1
		case 1:   	handler.addObject(new Player(400 ,400, "Player1", handler, 200,Color.cyan));
				  	handler.addObject(new Player(960 ,400, "Player2", handler, 1000,Color.CYAN));
					break;
		case 100:   handler.addObject(new Enemy());
				    break;
		case 200: 	handler.addObject(new Enemy());
		   		  	break;
		case 300: 	handler.addObject(new Enemy());
				  	break;
		case 390:	handler.addObject(new Enemy());			//Toevoegen en verwijderen van objecten
	  				break;
		case 410:	handler.addObject(new Enemy());
					break;
		case 430:	handler.addObject(new Enemy());
					break;
		case 450:	handler.addObject(new Enemy());
					break;
		case 600: 	removeAllType("Enemy");
				  	removeAllType("Enemy"); 			
				  	break;
	//WAVE2
		case 601:	handler.addObject(new BlobEnemy());	
					handler.addObject(new BlobEnemy());	
					handler.addObject(new BlobEnemy());	
					handler.addObject(new FollowingEnemy(50, 50, "Following", handler, "Player1"));
					handler.addObject(new FollowingEnemy(50, 50, "Following", handler, "Player2"));
					break;
					
		case 950: 	for(int i=0;i< 10 ; i++) {
						handler.addObject(new Enemy(5,i*80,4,0, "EnemyLine"));
					}
				   	break;
				   	
		case 1665: 	for(int j=0; j<10 ; j++) {
						removeAllType("EnemyLine");		
					}
					break;
					
		case 1799: 	removeAllType("Blob");
					removeAllType("Blob");
					break;
					
	//WAVE3	
		case 1800:  handler.addObject(new Enemy(7));
					handler.addObject(new Enemy(7));
					handler.addObject(new Enemy(7));
					break;
					
		case 2000:  handler.addObject(new HealthBox());
					break;
		
		case 2300: 	for(int i=0;i< 10 ; i++) {
						removeAllType("Enemy");
					}
					break;
	//WAVE4
		case 2400:  for(int i=0;i< 20 ; i++) {
						handler.addObject(new Enemy(i*80+25,5,0,4, "EnemyLine1"));
					}
					break;
					
		case 2500:
					for(int i=0;i< 10 ; i++) {
						handler.addObject(new Enemy(5,i*80,4,0, "EnemyLine2"));
					}
					break;
					
		case 2792: 	for(int j=0; j<20 ; j++) {
						removeAllType("EnemyLine1");		
					}	
					break;
					
		case 3215:
					for(int i=0;i< 10 ; i++) {
						removeAllType("EnemyLine2");
					}
					break;
					
		case 3220: 	handler.addObject(new VerticalEnemy(0, 10));
					removeAllType("Following");
					removeAllType("Following");
					break;
					
		case 3688:  removeAllType("VerticalEnemy");			//De verticale enemy verdwijnt net wanneer deze de muur raakt
					break;
					
		case 3750:  handler.addObject(new BlobEnemy());
					break;
					
		default:
					break;
			
			
			}
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
