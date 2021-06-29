package com.log.timmy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.LinkedList;

//trap monster class child of entity
public class Traps extends Entity  {
	 private float gravity =0.30f;
     private float  vy=0, vx=0.5f;
	private int w=40, h=60;
	
	private MultiObjects mb;
	Texture t = Game.getInst();
	public Traps(float x, float y, int width, int height,MultiObjects mb, Identity ID) {
		super(x, y, width, height, ID);
		this.mb=mb;
		
	}
	//updating the objects

	public void update(LinkedList<Entity> entity) {
	
		
			
			setX(getX() - vx);
		setY(getY() + vy);
		vy+=gravity;
		
		
		Collision(entity);
	}


	public void render(Graphics g) {
	
		g.drawImage(t.num4[0], (int)getX(),(int)getY(),null);
		
		///prototype before implementing image texture
		/*
		g.setColor(Color.green);
		g.fillRect((int)x,(int) y, w, h);
		Graphics2D g2d = (Graphics2D)g;
		g.setColor(Color.RED);
		g2d.draw(getBounds());
		g2d.draw(gettopBounds());
		
		*/
		
	}
	public void Collision (LinkedList<Entity> entity) {
		
		///collison algo: explained in ba enemy, explained throughly in documents
		
		for (int i=0; i<mb.entity.size(); i++) {
			Entity temp = mb.entity.get(i);
			
			if (temp.GetID()==Identity.PARTICLE) {
				if (getBounds().intersects(temp.getBounds())) {
				setY(temp.gety()-60);
				vy=-vy;
				vx=-vx;
			}
	if (gettopBounds().intersects(temp.getBounds())) {
					
					setY(temp.gety()+ 43);
					vy=0;
				}
			

			
			}
			if (temp.GetID()==Identity.PLAYER) {
				if (temp.getX()>150 && temp.getX()<300) {
					attack = true;
				}
				
				
				
				
				
			}
			
			
	
		}
	}

	private Rectangle gettopBounds() {
		return new Rectangle ((int) ((int)getX()+ (width/2)-((width/3)/2)),(int) getY(), w-14, (int) (h/2));
		
	}






	public  Rectangle getBounds() {
		return new Rectangle ( (int) ((int)getX()+ (width/2)-((width/3)/2)),(int) getY()+(h/2), w-14, (int) (h/2));
		
	}
	

}
