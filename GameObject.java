package SoftwareProject.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

// alle objects van de game in deze class
public abstract class GameObject {

	
		protected int x, y;	
		protected String type;
		protected int velX, velY; //speed
		
		public GameObject(String type) {
			Random r = new Random();
			x=r.nextInt(1300)+10;
			y=r.nextInt(650)+10;
			this.type=type;
		}
		
		public GameObject(int x, int y, String type){
			this.x = x;
			this.y = y;
			this.type = type;
		}
		
		public abstract void tick();
		public abstract void render(Graphics g);
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
		public void setType(String type) {
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
