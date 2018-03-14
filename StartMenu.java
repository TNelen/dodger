package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
//import java.awt.Graphics.getFontMetrics;

public class StartMenu extends Menu {

	public StartMenu(Game game, Handler handler) {
		super(game, handler);
		buttons.add(new ClickButton(fnt2, "Play", Color.WHITE, Color.WHITE, Color.BLACK, 7, 250));
		buttons.add(new ClickButton(fnt2, "Options", Color.WHITE, Color.WHITE, Color.BLACK, 7, 360));	//font, tekst, tekstkleur, randkleur,vulkleur,rand-dikte, y-coord
		buttons.add(new ClickButton(fnt2, "Exit", Color.WHITE, Color.WHITE, Color.BLACK, 7, 470));
	}

	//knop toevoegen => nieuwe buttons.add(new ClickButton....)
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		
		if(game.getState()==Game.STATE.Menu) {
			if(mouseOver(mx,my,buttons.get(0).getRectVal()[0],buttons.get(0).getRectVal()[1],buttons.get(0).getRectVal()[2],buttons.get(0).getRectVal()[3])) {			//Op deze manier kan mouseOver toch gebruikt worden
				game.setState(Game.STATE.Game);
			}else if(mouseOver(mx,my,buttons.get(1).getRectVal()[0],buttons.get(1).getRectVal()[1],buttons.get(1).getRectVal()[2],buttons.get(1).getRectVal()[3])) {			//Op deze manier kan mouseOver toch gebruikt worden
				game.setState(Game.STATE.End);
			}
		}
		
		
		/*if(mouseOver(mx,my,210,150,200,64)) {
			game.setState(Game.STATE.Game);
		}*/
		
	}
	
	
	
	
	public void render(Graphics g) {
		for(int i=0;i<buttons.size();i++) {
			buttons.get(i).draw(g);
		}
		
		
		super.drawStringCenter(g, fnt, "DODGER", Color.WHITE, 70);
		super.drawStringCenter(g, fnt3, "A Game By Timo & Wouter", Color.WHITE, 100);
		//super.drawStringCenter(g, fnt2, "Play", Color.WHITE, 190);
		//super.drawStringCenter(g, fnt2, "Help", Color.WHITE, 290);
		//super.drawStringCenter(g, fnt2, "Exit", Color.WHITE, 390);
		/*super.drawStringButtonCenter(g, fnt2, "Play", Color.WHITE, Color.WHITE, Color.BLACK, 7, 250);
		super.drawStringButtonCenter(g, fnt2, "Options", Color.WHITE, Color.WHITE, Color.BLACK, 7, 360);
		super.drawStringButtonCenter(g, fnt2, "Exit", Color.WHITE, Color.WHITE, Color.BLACK, 7, 470);
		*/
	}

}
