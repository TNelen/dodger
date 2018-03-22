package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;


//update en render game objects

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();		//Lijst met alle objecten
	Spawn spawn;
	boolean gameOver=false;
	String winner="";
	int highScore;
	
	public Handler() {
		spawn = new Spawn(this);						//Uit de spawn haalt de handler info over het tijdstip voor het aanmaken van nieuwe objecten
		
	}
	
	public boolean tick() {
		for(int i=0; i< object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();							//Laat alle objecten ticken
		}
		spawn.tick();
		
		
		return gameOver;								//Als een speler sterft, verandert deze de gameOver variabele in true. Deze wordt hier gereturned
		
		
	}
	
	public void reset(){
		winner="";
		gameOver=false;									//Wanneer het spel opnieuw gespeeld wordt, zal alles gereset worden
		object.clear();
		spawn = new Spawn(this);
	}
	
	public void setWinner(String w){
		winner = w;
	}
	
	public String getWinner(){
		return winner;									//Winner wordt geset vanuit de Player-klasse
	}
	
	public int getHighScore() {
		if(spawn.getScore()>highScore) {
			highScore = spawn.getScore();				//Haalt highscore op vanuit de Spawn
		}
		return highScore;
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
	
	public void setGameOver(boolean done) {
		gameOver = done;
	}
	public LinkedList<GameObject> getObjects() {
		return object;
	}
	
	
}
