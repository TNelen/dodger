package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class EndMenu extends Menu{

	public EndMenu(Game game, Handler handler) {
		super(game, handler);
		
	}
	
	
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		/*if(mouseOver(5,5,5,5,5,5)) {			//Op deze manier kan mouseOver toch gebruikt worden
			
		}*/
		
	}
	
	public void render(Graphics g) {
		super.drawStringCenter(g, fnt, "GAME OVER", Color.WHITE, Game.HEIGHT/2);
		super.drawStringCenter(g, fnt3, "Final Score: "+handler.spawn.getScore(), Color.WHITE, Game.HEIGHT/2+60);
	}
	

}
