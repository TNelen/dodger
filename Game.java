package SoftwareProject.main;



import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 8867199718729913515L;
	public static final int WIDTH = 1440, HEIGHT = 810;

	// dit is de main class
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	
	public Game() {
		new Window(WIDTH, HEIGHT, "dit is demo versie! ", this);
		
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler)); //dit is nodig voor de keyinput
		
		

	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() { 
		this.requestFocus();   //hierdoor kan je gelijk besturen en moet je niet eerst klikken in het window
		
		// inspiratie :https://stackoverflow.com/questions/27628844/better-game-loop-engine
		/* checks whether enough time has passed (1/60 sec) to refresh the game, 
		 and checks whether enough time has passed (1 sec) to refresh the FPS counter;
		while 'running' it adds the time it took to go through one iteration of the loop it self 
		and adds it to delta (which is simplified to 1) so once it reaches 1 delta it means 
		enough time has passed to go forward one tick.*/
		  long lastTime = System.nanoTime(); // huidige tijd in ns
		  double amountOfTicks = 60.0; // number of ticks
		  double ns = 1000000000 / amountOfTicks; 
		  double delta = 0; 
		  long timer = System.currentTimeMillis(); 
		  int frames = 0; // set frame variable
		  while(running){ 
		   long now = System.nanoTime(); 
		   delta += (now - lastTime) / ns; 
		   lastTime = now; 
		   while(delta >= 1){
			   tick();  
			   delta--;  
		   }
		   if(running)
			   render(); 
		   frames++; 
		   if(System.currentTimeMillis() - timer > 1000 ){ 
		    timer+= 1000; 
		    System.out.println("FPS: " + frames); 
		    frames = 0; 
		   }
		  }
		  stop();
		 }
	
	private void tick() {
		handler.tick();
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);  //een aantal buffers maken, max 3
			return;
		}
		
		Graphics g= bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0, WIDTH, HEIGHT);
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	public static int border(int var, int min , int max) { //hierdoor kan speler niet buiten grenzen van window bewegen
		if(var>= max)
			return var = max;
		else if (var<= min)
			return var = min;
		else
			return var;
		
	}
	
	public static void main(String args[]) throws Exception{
		new Game();
	}
}
