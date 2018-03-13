package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.MouseEvent;
//import java.awt.Graphics.getFontMetrics;

public class StartMenu extends Menu {

	public StartMenu(Game game, Handler handler) {
		super(game, handler);
		
	}

	
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		/*if(mouseOver(5,5,5,5,5,5)) {			//Op deze manier kan mouseOver toch gebruikt worden
			
		}*/
		
	}
	
	public void render(Graphics g) {
		super.drawStringCenter(g, fnt, "DODGER", Color.WHITE, 70);
		super.drawStringCenter(g, fnt3, "A Game By Timo & Wouter", Color.WHITE, 100);
		/*super.drawStringCenter(g, fnt2, "Play", Color.WHITE, 190);
		super.drawStringCenter(g, fnt2, "Help", Color.WHITE, 290);
		super.drawStringCenter(g, fnt2, "Exit", Color.WHITE, 390);*/
		super.drawStringButtonCenter(g, fnt2, "Play", Color.WHITE, Color.WHITE, Color.BLACK, 7, 250);
		super.drawStringButtonCenter(g, fnt2, "Options", Color.WHITE, Color.WHITE, Color.BLACK, 7, 360);
		super.drawStringButtonCenter(g, fnt2, "Exit", Color.WHITE, Color.WHITE, Color.BLACK, 7, 470);
	}

}
