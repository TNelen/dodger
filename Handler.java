package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;


//update en render game objects

public class Handler {
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	Spawn spawn;
	
	public Handler() {
		spawn = new Spawn(this);
		
	}
	
	public void tick() {
		for(int i=0; i< object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
		spawn.tick();
		/*if(spawn.getScore()==600) {
			
			removeEnemies();
		}*/
	}
	
	public void render(Graphics g) {
		for(int i=0; i< object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
		spawn.render(g);
	}
	
	public void addPlayer() {
		this.object.add(new Player(400 ,400, "Player3", this, 200,Color.yellow));
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	/*public void removeEnemies() {
		for(GameObject obj : object) {
			if(obj.getType().equals("Enemy")) {					//RemoveEnemies werkt nog niet aangezien verwijderde enemies toch nog door de thread aangesproken worden (concurrency)
				object.remove(obj);
				obj = null;
			}
		}
	}*/
	
	public LinkedList<GameObject> getObjects() {
		return object;
	}
	
}
