package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;


//update en render game objects

public class Handler {
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	Spawn spawn;
	boolean gameOver=false;
	String winner="";
	
	public Handler() {
		spawn = new Spawn(this);
		
	}
	
	public boolean tick() {
		for(int i=0; i< object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
		spawn.tick();
		
		
		return gameOver;
		
		/*if(spawn.getScore()==600) {
			
			removeEnemies();
		}*/
	}
	
	public void reset(){
		winner="";
		gameOver=false;
		object.clear();
		spawn = new Spawn(this);
	}
	
	public void setWinner(String w){
		winner = w;
	}
	
	public String getWinner(){
		return winner;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);					//Achtergrondkleur
		g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);	
		
		for(int i=0; i< object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
		spawn.render(g);
		
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
	
	public void setGameOver(boolean done) {
		gameOver = done;
	}
	public LinkedList<GameObject> getObjects() {
		return object;
	}
	
	
}
