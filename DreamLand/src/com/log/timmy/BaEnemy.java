package com.log.timmy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.LinkedList;
// simple movement enemy: one of child class of entity
public class BaEnemy extends Entity  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float gravity =0.50f;
    private float  vy=0, vx=1f;
	private int w=40, h=60;
	Texture t = Game.getInst();
	
	private MultiObjects mb;
	
	 public BaEnemy(float x, float y, int width, int height, MultiObjects mb, Identity ID) {
		super(x, y, width, height, ID);
		this.mb = mb;
	}


	public void update(LinkedList<Entity> entity) {
	
		
			
			setX(getX() + vx);
		
		
		Collision(entity);
	}


	public void render(Graphics g) {
	
		g.drawImage(t.num3[0], (int)getX(),(int)getY(),null);
		///function used in prototype before using texture above
		
		/*g.setColor(Color.PINK);
		g.fillRect((int)x,(int) y, w, h);
		Graphics2D g2d = (Graphics2D)g;
		g.setColor(Color.BLACK);
		g2d.draw(getBounds());
		g2d.draw(getrightBounds());
		*/
		
		
	}
	public void Collision (LinkedList<Entity> entity) {
		//collison algorithm: refer to documentation for better understanding:
		//Using rectangle body for different entities and determining if any of the rectangle intersected other rectangle resulting in following function
		for (int i=0; i<mb.entity.size(); i++) {
			Entity temp = mb.entity.get(i);
			
			if (temp.GetID()==Identity.PARTICLE) {
				if (getBounds().intersects(temp.getBounds())) {
				//accelerating and deaccelerating the object: if left rectangle hits particles it will start accelerating in opp. direction
				
				vx=-3;
			}
	if (getrightBounds().intersects(temp.getBounds())) {
				//vice versa as above	
					vx=3;
				}
			


			
			}
			
				
				
				
				
			
			
			
	
		}
	}
	
	




	private Rectangle getrightBounds() {
		return new Rectangle ((int)getX(),(int) getY(), (int) w-14, h);
	}


	
	


	@Override
	public Rectangle getBounds() {
		return new Rectangle ((int)getX()+12,(int) getY(), w-14, h);
	
	}
	}


	
