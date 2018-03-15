package SoftwareProject.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class Menu extends MouseAdapter {
	protected Game game;
	protected Handler handler;
	String letterType = "Tahoma";
	Font fnt = new Font(letterType,1,50);
	Font fnt2 = new Font(letterType,1,30);
	Font fnt3 = new Font(letterType,1,20);
	Font fnt4 = new Font(letterType,1,15);
	Font fnt5 = new Font(letterType,1,80);
	//private HUD hud;
	
	ArrayList<ClickButton> buttons;
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
		buttons = new ArrayList<ClickButton>();
	}
	
	public void mousePressed(MouseEvent e){
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	protected boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx>x && mx< x + width){
			if(my < y && my > y + height) {		//aangepast omdat ik in de war zat, werkt wel
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick() {
	}
	
	public void drawStringCenter(Graphics g, Font f, String s, Color c, int y) {
		g.setFont(f);
		g.setColor(c);
		g.drawString(s, Game.WIDTH/2 - (g.getFontMetrics(f).stringWidth(s))/2, y);
	}
	
	/*public void drawStringButtonCenter(Graphics g, Font f, String s, Color tc, Color boc, Color buc, int thick, int y) {
		
		int sWidth=g.getFontMetrics(f).stringWidth("PLAY");
		int sHeight=((int) g.getFontMetrics(f).getLineMetrics("PLAY", g).getDescent() + (int) g.getFontMetrics(f).getLineMetrics("PLAY", g).getDescent())*2;
		
		
		Rectangle border = new Rectangle(Game.WIDTH/2-(sWidth/2)-(40+thick),y+(20+thick),sWidth+(40+thick)*2, -sHeight - (20+thick)*2);
		Rectangle button = new Rectangle(Game.WIDTH/2-(sWidth/2)-40,y+20,sWidth+80, -sHeight - 40);
		
		g.setColor(boc);
		g.fillRect((int) border.getX(), (int) border.getY(), (int) border.getWidth(), (int) border.getHeight());
		g.setColor(buc);
		g.fillRect((int) button.getX(), (int) button.getY(), (int) button.getWidth(), (int) button.getHeight());
		
		g.setFont(f);
		g.setColor(tc);
		g.drawString(s, Game.WIDTH/2 - (g.getFontMetrics(f).stringWidth(s))/2, y);
		
	}*/
	
	
	public void render(Graphics g) {
		
			
	}

	
}
