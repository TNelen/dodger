package SoftwareProject.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.Graphics.*;


public class Menu extends MouseAdapter {
	private Game game;
	protected Handler handler;
	private Random r = new Random();
	String letterType = "Tahoma";
	Font fnt = new Font(letterType,1,50);
	Font fnt2 = new Font(letterType,1,30);
	Font fnt3 = new Font(letterType,1,20);
	Font fnt4 = new Font(letterType,1,15);
	//private HUD hud;
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
		
	}
	
	public void mousePressed(MouseEvent e){
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	protected boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx>x && mx< x + width){
			if(my > y && my < y + height) {
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
	
	public void drawStringButtonCenter(Graphics g, Font f, String s, Color tc, Color boc, Color buc, int thick, int y) {
		
		int sWidth=g.getFontMetrics(f).stringWidth("PLAY");
		int sHeight=((int) g.getFontMetrics(f).getLineMetrics("PLAY", g).getDescent() + (int) g.getFontMetrics(f).getLineMetrics("PLAY", g).getDescent())*2;
		
		g.setColor(boc);
		g.fillRect(Game.WIDTH/2-(sWidth/2)-(40+thick),y+(20+thick),sWidth+(40+thick)*2, -sHeight - (20+thick)*2);
		g.setColor(buc);
		g.fillRect(Game.WIDTH/2-(sWidth/2)-40,y+20,sWidth+80, -sHeight - 40);
		
		g.setFont(f);
		g.setColor(tc);
		g.drawString(s, Game.WIDTH/2 - (g.getFontMetrics(f).stringWidth(s))/2, y);
		
		/*
		g.setColor(boc);
		g.fillRect(Game.WIDTH/2 - (sWidth/2)-(20+thick), y-sHeight-(20+thick), sWidth+((20+thick)*2), sHeight+((20+thick)*2));
		g.setColor(buc);
		g.fillRect(Game.WIDTH/2 - (sWidth/2)-20, y-sHeight-20, sWidth+40, sHeight+40);
		*/
		
		/*g.setColor(boc);
		g.fillRect(Game.WIDTH/2 - (sWidth/2),y-sHeight,sWidth, sHeight);
		*/
	}
	
	
	public void render(Graphics g) {
		
			
			
			
		/*if (gameState == STATE.Menu) {
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("DODGER", 205, 70);
			g.setFont(fnt3);
			g.drawString("An Omitoz game", 235,100);
		
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Play",270,190);
		
			g.setColor(Color.white);
			g.drawRect(210, 250, 200, 64);
			g.drawString("Help",270,290);
		
			g.setColor(Color.white);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Exit",270,390);
			
		}else if(gameState == STATE.Help) {
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Help", 240, 70);
			
			g.setFont(fnt3);
			g.drawRect(450, 380, 100, 32);
			g.drawString("Back",470,403);
			
			g.setFont(fnt4);
			g.drawString("Use ZQSD to move player 1",150,150);
			g.drawString("Use ARROW keys to move player 2",150,170);
		
		
		} }else if(gameState == STATE.End) {
				g.setFont(fnt);
				g.setColor(Color.WHITE);
				g.drawString("GAME OVER", (Game.WIDTH/2) - 200, Game.HEIGHT/2);
				
				g.setFont(fnt4);
				g.drawString("Final Score: "+handler.spawn.getScore(),(Game.WIDTH/2) - 90, Game.HEIGHT/2+50);
			}*/
		
		
	}
}
