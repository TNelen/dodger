package SoftwareProject.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

//update en render game objects

public class Handler {
	ArrayList<LinkedList<GameObject>> allObjects = new ArrayList<LinkedList<GameObject>>();
	LinkedList<Player> players = new LinkedList<Player>();
	LinkedList<Enemy> enemies = new LinkedList<Enemy>();
	
	public Handler() {
		allObjects.add(players);
		allObjects.add(enemies);
	}
	
	public void tick() {
		for(LinkedList<GameObject> list : allObjects) {
			for(int i=0; i< list.size(); i++) {
				GameObject tempObject = list.get(i);
				tempObject.tick();
			}
		}
		
		for(Player pl : players) {
			
		}
		
		
		
	}
	public void render(Graphics g) {
		
		for(LinkedList<GameObject> list : allObjects) {
			for(int i=0; i< list.size(); i++) {
				GameObject tempObject = list.get(i);
				
				tempObject.render(g);
			}
		}
		
	}
	
	public void addObject(GameObject object) {
		
	switch(object.getType().toLowerCase()) {
		case "enemy": enemies.add(object);
			break;
		case "player1": players.add(object);
			break;
		case "player2": players.add(object);
			break;
		default:
			break;
	}
		
		//name.substring(0, name.length()-1).equals("player")) 
			
	}
	
	public void removeObject(GameObject object) {
		
		switch(object.getType().toLowerCase()) {
			case "enemy": enemies.remove(object);
				break;
			case "player1": players.remove(object);
				break;
			case "player2": players.remove(object);
				break;
			default:
				break;
		}
		
		//this.object.remove(object);
	}
	
	public boolean collision(GameObject player, GameObject object) {
		
		if(player.getBounds().intersects(object.getBounds())) {
			return true;
		}else {
			return false;
		}
	}

	
	
}
