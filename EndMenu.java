package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class EndMenu extends Menu{

	public EndMenu(Game game, Handler handler) {
		super(game, handler);
		buttons.add(new ClickButton(fnt2, "Try Again", Color.WHITE, Color.WHITE, Color.BLACK, 7, Game.HEIGHT/2+250));
		
	}
	
	
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		try {
		if(game.getState()==Game.STATE.End) {
			if(mouseOver(mx,my,buttons.get(0).getRectVal()[0],buttons.get(0).getRectVal()[1],buttons.get(0).getRectVal()[2],buttons.get(0).getRectVal()[3])) {			//Op deze manier kan mouseOver toch gebruikt worden
				handler.reset();
				game.setState(Game.STATE.Game);
				
			}
		}
		}catch(Exception p) {
			System.out.println("Fuck NullPointerExceptions");
		}
		
		/*if(mouseOver(5,5,5,5,5,5)) {			//Op deze manier kan mouseOver toch gebruikt worden
			
		}*/
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);		//Achtergrondkleur
		
		for(int i=0;i<buttons.size();i++) {
			buttons.get(i).draw(g);
		}
		
		super.drawStringCenter(g, fnt5, "GAME OVER", Color.WHITE, Game.WIDTH/2, Game.HEIGHT/2);
		super.drawStringCenter(g, fnt2, handler.getWinner()+" is the winner!", Color.WHITE, Game.WIDTH/2, Game.HEIGHT/2+60);
		super.drawStringCenter(g, fnt2, "Final Score: "+handler.spawn.getScore(), Color.WHITE, Game.WIDTH/2, Game.HEIGHT/2+120);
		
	}
	

}
