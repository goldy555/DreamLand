package com.log.timmy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.io.Serializable;
import java.util.LinkedList;

public class Player extends Entity {
     /**
	 * 
	 */
	//user controlled player class child of entity.
	private static final long serialVersionUID = 1L;
	Texture t = Game.getInst();
	private float gravity =0.06f;
     private float  vy=0, vx=0;
	private int w=40, h=60;
	private int maxJump=2;
	private MultiObjects mb;
	public Player(float x, float y,int w, int h,MultiObjects mb,Identity ID) {
		super(x, y, w, h, ID);
	    this.mb =mb;
		
	}


	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.drawImage(t.num2[0], (int)getX(),(int)getY(),null);
		
		
		//prototype before implementing above texture.
		/*g.setColor(Color.black);
		g.fillRect((int)x,(int) y, w, h);
		
		Graphics2D g2d = (Graphics2D)g;
		g.setColor(Color.RED);
		g2d.draw(getBounds());
		g2d.draw(gettopBounds());
	g2d.draw(getleftBounds());
		g2d.draw(getrightBounds());
		
		*/
		
	}
	
	//COllision algo: $ rectangles covering four side of the player body. In case other rectangle intersect any of the rectangle it will result in  certain code being executed in that condition body.
	private Rectangle gettopBounds() {
		return new Rectangle ((int) ((int)getX()+ (width/2)-((width/3)/2))+5,(int) getY(), w-22, (int) (h/2));
		
	}




	private Rectangle getleftBounds() {
		return new Rectangle ((int)getX()+27,(int) getY(), w-30, h);
	}




	private Rectangle getrightBounds() {
		return new Rectangle ((int)getX(),(int) getY(), (int) w-30, h);
	}




	public  Rectangle getBounds() {
		return new Rectangle ( (int) ((int)getX()+ (width/2)-((width/3)/2))+6,(int) getY()+(h/2), w-23, (int) (h/2));
		
	}

	public void update(LinkedList<Entity> entity) {
		setX(getX() + vx);
		setY(getY() + vy);
		

		
		if (fall || collide) {
			
			vy+=gravity;
			if (vy>maxJump) {
				
				vy = maxJump;
			}
			
		}
		
		
		
	Collision(entity);
	}

	public void Collision (LinkedList<Entity> entity) {
	
		for (int i=0; i<mb.entity.size(); i++) {
			Entity temp = mb.entity.get(i);
			
			if (temp.GetID()==Identity.PARTICLE) {
			
				
				
				if (gettopBounds().intersects(temp.getBounds())) {
					
					setY(temp.gety()+ 43);
					vy=0;
				}
				
				
				if (getBounds().intersects(temp.getBounds())) {
					
					setY(temp.gety()-60);
					vy=0;
					
					fall = false;
					collide = false;
				}
				else {
					fall = true;
				}
if (getrightBounds().intersects(temp.getBounds())) {
					
					setX((temp.getx()+40));
				
				}
if (getleftBounds().intersects(temp.getBounds())) {
	
	setX(temp.getx() -40);
	
}
				
				

			}
			//incase any of rectangle intersects the object rectangle that is linked with smarte, it will result in following code being executed.
			
			if (temp.GetID()==Identity.SMARTE) {
				
				if (getBounds().intersects(temp.getBounds()) || getrightBounds().intersects(temp.getBounds())||  getleftBounds().intersects(temp.getBounds()) ) {
					Game.a=(int) getX();
					Game.GameOver = true;
					
				}
				
				
				
				
			}
	//same as above		
			if (temp.GetID()==Identity.ENEMY) {
				
				if (gettopBounds().intersects(temp.getBounds()) || getrightBounds().intersects(temp.getBounds())||  getleftBounds().intersects(temp.getBounds()) ) {
					Game.a=(int) getX();
					Game.GameOver = true;
					
				}
				
				
				
				
				
			}
			
			
		}
		
		
		
	}


//getter and setters.
	public double getVy() {
		return vy;
	}




	public void setVy(float vy) {
		this.vy = vy;
	}




	public double getVx() {
		return vx;
	}




	public void setVx(float vx) {
		this.vx = vx;
	}




	public int getW() {
		return w;
	}




	public void setW(int w) {
		this.w = w;
	}




	public int getH() {
		return h;
	}




	public void setH(int h) {
		this.h = h;
	}
	
	
}
