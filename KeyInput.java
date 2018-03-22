package SoftwareProject.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	private boolean[] keyDown = new boolean[8];
	private int v=5;										//Snelheid van de speler wanneer een knop wordt ingedrukt
	
	
	public KeyInput(Handler handler){
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
		keyDown[4] = false;
		keyDown[5] = false;
		keyDown[6] = false;
		keyDown[7] = false;
				
	}
	
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i); 				//Loopt door alle objecten
					if (tempObject.getType().equals("Player1")) {
				
				if(key == KeyEvent.VK_Z) { tempObject.setVelY(-v);			keyDown[0] = true; }
				if(key == KeyEvent.VK_S) { tempObject.setVelY(v);			keyDown[1] = true; }
				if(key == KeyEvent.VK_Q) { tempObject.setVelX(-v);			keyDown[2] = true; }		//Key events Player 1
				if(key == KeyEvent.VK_D) { tempObject.setVelX(v);			keyDown[3] = true; }

					
			} 
			if(tempObject.getType().equals("Player2")) {
				
				if(key == KeyEvent.VK_UP)	{tempObject.setVelY(-v);	  	keyDown[4] = true; }
				if(key == KeyEvent.VK_DOWN) {tempObject.setVelY(v);			keyDown[5] = true; }
				if(key == KeyEvent.VK_LEFT) {tempObject.setVelX(-v);		keyDown[6] = true; }		//Key events Player 1
				if(key == KeyEvent.VK_RIGHT) {tempObject.setVelX(v); 		keyDown[7] = true; }
				
				
			} 
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1); 					//Escape sluit game af
		
	}
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();

			
			for(int i=0; i<handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i); 				//Loopt door alle objecten
			
				if (tempObject.getType().equals("Player1")) {
					
				
					if(key == KeyEvent.VK_Z) 	keyDown[0] = false;	 
					if(key == KeyEvent.VK_S) 	keyDown[1] = false;			//Key releases player 1
					if(key == KeyEvent.VK_Q) 	keyDown[2] = false;
					if(key == KeyEvent.VK_D) 	keyDown[3] = false;
					
					//vertical 
					if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);

					//horizontal
					if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
						
				} 
				if(tempObject.getType().equals("Player2")) {
					
					if(key == KeyEvent.VK_UP) 		keyDown[4] = false;		
					if(key == KeyEvent.VK_DOWN)		keyDown[5] = false;		
					if(key == KeyEvent.VK_LEFT) 	keyDown[6] = false;		//Key releases player 2
					if(key == KeyEvent.VK_RIGHT)	keyDown[7] = false;		
					
					//vertical
					if(!keyDown[4] && !keyDown[5]) tempObject.setVelY(0);
					//horizontal
					if(!keyDown[6] && !keyDown[7]) tempObject.setVelX(0);

				} 
				
			}
			

	}
	
}
