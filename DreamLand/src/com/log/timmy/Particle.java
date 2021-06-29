package com.log.timmy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.LinkedList;
//block class making the world child of entity
public class Particle extends Entity  {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int w =40, h=40;
Texture t = Game.getInst();

	public Particle(float x, float y, int w, int h, Identity ID) {
		super(x, y, w, h, ID);
		
	}

	
	public void update(LinkedList<Entity> entity) {
		
		
	}

	
	public void render(Graphics g) {
		g.drawImage(t.num[0], (int)getX(),(int)getY(),null);
		//g.setColor(Color.WHITE);
		//g.drawRect((int)x,(int) y, w, h);
	}


	public  Rectangle getBounds() {
		return new Rectangle ((int)getX(),(int) getY(), w, h);
	}



	

}
