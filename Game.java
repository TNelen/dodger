package SoftwareProject.main;



import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;



public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 8867199718729913515L;
	public static final int WIDTH = 1440, HEIGHT = 810;							//Deze class bevat het main-statement

	
	private Thread thread;
	private boolean running = false;
	
	STATE gameState = STATE.Menu;
	
	private Handler handler;
	private Menu startMenu, endMenu,optionsMenu;
	
    

	
	public enum STATE {
		Menu,
		Help,				//Alle gamestates
		Game,
		End;
	};
	
	public Game() {
		new Window(WIDTH, HEIGHT, "DODGER DEMO", this);		//Window aanmaken waar de hele game zich zal afspelen
		
		handler = new Handler();
		
		this.addKeyListener(new KeyInput(handler)); 		//Keyinput luistert naar het indrukken van toetsen
		
		
		//AudioPlayer player = new AudioPlayer();	
		//player.play(audioFilePath);
		startMenu = new StartMenu(this,handler);
		endMenu = new EndMenu(this,handler);
		optionsMenu = new OptionsMenu(this,handler);		//Menu's aanmaken
		
		this.addMouseListener(startMenu);
		this.addMouseListener(endMenu);
		this.addMouseListener(optionsMenu);					//Menu's luisteren naar muisinput
					

	}

	public void setState(STATE s){
		gameState = s;
		
	}
	
	public STATE getState() {
		return gameState;
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();								//Start de Gamethread
		running = true;
	}
	public synchronized void stop() {
		try {
			thread.join();
			running = false;				//Stopt de gamethread
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() { 
		this.requestFocus();   //Hierdoor kmoet niet eerst in het window geklikt worden om te kunnen bewegen.
		
		// inspiratie :https://stackoverflow.com/questions/27628844/better-game-loop-engine
		
		/* Checks whether enough time has passed (1/60 sec) to refresh the game, 
		 and checks whether enough time has passed (1 sec) to refresh the FPS counter.
		While 'running' it adds the time it took to go through one iteration of the loop it self 
		and adds it to delta (which is simplified to 1) so once it reaches 1 delta it means 
		enough time has passed to go forward one tick.*/
		
		
		  long lastTime = System.nanoTime(); 		//Huidige tijd in ns
		  double amountOfTicks = 60.0; 				// Aantal ticks
		  double ns = 1000000000 / amountOfTicks; 
		  double delta = 0; 
		  long timer = System.currentTimeMillis(); 
		  int frames = 0; 							//Set frame variabele
		  while(running){ 
		   long now = System.nanoTime(); 
		   delta += (now - lastTime) / ns; 
		   lastTime = now; 							 //Delta berekenen
		   
		   while(delta >= 1){
			   tick();  					//Aan de hand van delta wordt er getickt
			   delta--;  
		   }
		   
		   if(running)
			   render(); 
		   frames++; 					//FPS updaten aangezien er gerenderd is
		   
		   if(System.currentTimeMillis() - timer > 1000 ){ 
		    timer+= 1000; 
		    System.out.println("FPS: " + frames); 
		    frames = 0; 				//Output FPS
		   }
		  }
		  stop();
		 }
	
	private void tick() {
		
		if(gameState==STATE.Menu) {		//Naargelang de state van de game, moet een ander menu/scherm ticken
			startMenu.tick();
		}else if(gameState == STATE.Game) {
			if(handler.tick()==true) {		//Checkt of de game gedaan is
				setState(STATE.End);
			}
		}else if(gameState == STATE.End) {			
			endMenu.tick();
		}else if(gameState == STATE.Help){
			optionsMenu.tick();
		}
				
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);  //Maakt een aantal buffers, max 3
			return;
		}
		
		Graphics g= bs.getDrawGraphics();
		
		g.setColor(Color.LIGHT_GRAY);
		//g.setColor(Color.getHSBColor(56, 62, 94));			//Om kleur te kiezen met de HSB code van die kleur
		
		g.fillRect(0,0, WIDTH, HEIGHT);		//Standaard-Achtergrondkleur
		try {
			if(gameState==STATE.Menu) {
				startMenu.render(g);
			}else if(gameState==STATE.Game) {			//Naargelang de state van de game, moet een ander menu/scherm renderen
				handler.render(g);
			}else if(gameState==STATE.End) {
				endMenu.render(g);
			}else if(gameState==STATE.Help){
				optionsMenu.render(g);
				
			}
		}catch(Exception m) {
			System.out.println("Nullpointboot");	//negeer dit maar
		}
		
		g.dispose();
		bs.show();		//Plaatst de graphics op het scherm
	}
	
	public static int border(int var, int min , int max) { 
		if(var>= max)
			return var = max;
		else if (var<= min)
			return var = min;				//Hierdoor kan speler niet buiten grenzen van window bewegen
		else
			return var;
		
	}
	
	public static void main(String args[]) throws Exception{
		
		String audioFilePath = System.getProperty("user.dir") + "\\resources\\audio\\ES.wav";
		//String audioFilePath = "C:\\Users\\User\\Desktop\\GameSoundtrack.wav";					//Zet hier het path naar de .wav muziek file
		AudioPlayer player = new AudioPlayer();	
		player.setPath(audioFilePath);
		player.start();			//Soundtrack wordt gestart
		
		new Game();				//Game gestart
		
		
		
	}
}
