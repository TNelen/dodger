package SoftwareProject.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

// alle objects van de game in deze class
public abstract class GameObject {

	
		protected int x, y;	
		protected String type;
		protected int velX, velY; 		//Speed
		
		public GameObject(String type) {
			Random p = new Random();
			x=p.nextInt(1100)+10;				//Objecten met deze constructor worden willekeurig geplaatst
			y=p.nextInt(650)+10;
			this.type=type;
		}
		
		public void reset(){
			
		}
		
		public GameObject(int x, int y, String type){
			this.x = x;
			this.y = y;							//Objecten met deze constructor worden op een bepaalde plek geplaatst
			this.type = type;
		}
		
		public abstract void tick();
		public abstract void render(Graphics g);		//Iedere instance van GameObject heeft deze methods
		public abstract Rectangle getBounds();
		
		public void setX(int x) {
			this.x = x;
		}
		
		public void setY(int y) {
			this.y = y;
		}
		
		public int getX() {
			return x;	
		}
		public int getY() {
			return y;
		}
		public void setType(String type) {				//Get en Set de variabelen
			this.type = type;
		}
		public String getType() {
			return type;
		}
		public void setVelX(int velX) {
			this.velX = velX;
		}
		public void setVelY(int velY) {
			this.velY = velY;
		}
		public int getVelX() {
			return velX;
		}
		public int getVelY() {
			return velY;
		}
}
