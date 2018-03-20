package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
//import java.awt.Graphics.getFontMetrics;

public class StartMenu extends Menu {

	public StartMenu(Game game, Handler handler) {
		super(game, handler);
		buttons.add(new ClickButton(fnt2, "Play", Color.WHITE, Color.WHITE, Color.BLACK, 7, 370));
		buttons.add(new ClickButton(fnt2, "Options", Color.WHITE, Color.WHITE, Color.BLACK, 7, 480));	//font, tekst, tekstkleur, randkleur,vulkleur,rand-dikte, y-coord
		buttons.add(new ClickButton(fnt2, "Exit", Color.WHITE, Color.WHITE, Color.BLACK, 7, 590));
	}

	//knop toevoegen => nieuwe buttons.add(new ClickButton....)
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		int[][] values = new int[4][10];
		
		for(int i=0;i<buttons.size();i++) {
			values[i]=buttons.get(i).getRectVal();
		}
		
		if(game.getState()==Game.STATE.Menu) {
			if(mouseOver(mx,my,values[0][0],values[0][1],values[0][2],values[0][3])) {			//Op deze manier kan mouseOver toch gebruikt worden
				game.setState(Game.STATE.Game);
			}else if(mouseOver(mx,my,values[1][0],values[1][1],values[1][2],values[1][3])) {			//Op deze manier kan mouseOver toch gebruikt worden
				game.setState(Game.STATE.Help);
			}
			else if(mouseOver(mx,my,values[2][0],values[2][1],values[2][2],values[2][3])) {			//Op deze manier kan mouseOver toch gebruikt worden
				//game.setState(Game.STATE.End);
				System.exit(1);
			}
		}
		
		/*
		if(game.getState()==Game.STATE.Menu) {
			if(mouseOver(mx,my,buttons.get(0).getRectVal()[0],buttons.get(0).getRectVal()[1],buttons.get(0).getRectVal()[2],buttons.get(0).getRectVal()[3])) {			//Op deze manier kan mouseOver toch gebruikt worden
				game.setState(Game.STATE.Game);
			}else if(mouseOver(mx,my,buttons.get(1).getRectVal()[0],buttons.get(1).getRectVal()[1],buttons.get(1).getRectVal()[2],buttons.get(1).getRectVal()[3])) {			//Op deze manier kan mouseOver toch gebruikt worden
				game.setState(Game.STATE.Help);
			}
			else if(mouseOver(mx,my,buttons.get(2).getRectVal()[0],buttons.get(2).getRectVal()[1],buttons.get(2).getRectVal()[2],buttons.get(2).getRectVal()[3])) {			//Op deze manier kan mouseOver toch gebruikt worden
				//game.setState(Game.STATE.End);
				System.exit(1);
			}
		}
		*/
		
		
		/*if(mouseOver(mx,my,210,150,200,64)) {
			game.setState(Game.STATE.Game);
		}*/
		
	}
	
	
	
	
	public void render(Graphics g) {
		/*g.setColor(Color.DARK_GRAY);
		g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);		//Achtergrondkleur
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
