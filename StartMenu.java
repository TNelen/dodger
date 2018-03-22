package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
//import java.awt.Graphics.getFontMetrics;

public class StartMenu extends Menu {

	public StartMenu(Game game, Handler handler) {
		super(game, handler);
		buttons.add(new ClickButton(fnt2, "Play", Color.WHITE, Color.WHITE, Color.BLACK, 7, 370));
		buttons.add(new ClickButton(fnt2, "Options", Color.WHITE, Color.WHITE, Color.BLACK, 7, 480));	//Font, tekst, tekstkleur, randkleur,vulkleur,rand-dikte, y-coord
		buttons.add(new ClickButton(fnt2, "Exit", Color.WHITE, Color.WHITE, Color.BLACK, 7, 590));
	}

	//Om knop toe te voegen => nieuwe buttons.add(new ClickButton....)
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		int[][] values = new int[4][10];
		
		
		for(int i=0;i<buttons.size();i++) {
			values[i]=buttons.get(i).getRectVal();
		}
		
		
		if(game.getState()==Game.STATE.Menu) {
			if(mouseOver(mx,my,values[0][0],values[0][1],values[0][2],values[0][3])) {					//Game spelen
				game.setState(Game.STATE.Game);
			}else if(mouseOver(mx,my,values[1][0],values[1][1],values[1][2],values[1][3])) {			//Opties
				game.setState(Game.STATE.Help);
			}	
			else if(mouseOver(mx,my,values[2][0],values[2][1],values[2][2],values[2][3])) {				//Verlaat spel
				System.exit(1);
			}
		}
		
	}
	
	public void reset() {
		buttons.set(0,new ClickButton(fnt2, "Play", Color.WHITE, Color.WHITE, Color.BLACK, 7, 370));
		buttons.set(1,new ClickButton(fnt2, "Options", Color.WHITE, Color.WHITE, Color.BLACK, 7, 480));	//Buttons terug resetten
		buttons.set(2,new ClickButton(fnt2, "Exit", Color.WHITE, Color.WHITE, Color.BLACK, 7, 590));
	}
	
	
	public void render(Graphics g) {
		/*g.setColor(Color.DARK_GRAY);
		g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);		//Om achtergrondkleur makkelijk te veranderen
		*/
		
		for(int i=0;i<buttons.size();i++) {
			buttons.get(i).draw(g);
		}
		
		
		super.drawStringCenter(g, fnt, "DODGER", Color.BLACK, (Game.WIDTH/2)-5, 144);
		super.drawStringCenter(g, fnt, "DODGER", Color.BLACK, (Game.WIDTH/2), 140);
		super.drawStringCenter(g, fnt, "DODGER", Color.WHITE, Game.WIDTH/2, 140);
		
		super.drawStringCenter(g, fnt3, "A Game By Timo & Wouter", Color.BLACK, Game.WIDTH/2, 190);
	}

}
