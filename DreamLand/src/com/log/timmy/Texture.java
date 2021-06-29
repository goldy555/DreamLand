package com.log.timmy;

import java.awt.image.BufferedImage;

public class Texture {
//different objects being intialized
	Sprites pars, ps, ts, es;
	
	private BufferedImage Particle_s = null;
	private BufferedImage Player_s = null;
	private BufferedImage Trap_s = null;
	private BufferedImage Enemy_s = null;
	
	
	public BufferedImage[] num = new BufferedImage[4];
	public BufferedImage[] num2 = new BufferedImage[2];
	public BufferedImage[] num3 = new BufferedImage[2];
	public BufferedImage[] num4 = new BufferedImage[2];
	public Texture() {
		
		ImageLoader load = new ImageLoader();
		// loads certain image from following file location.
		Particle_s = load.Loader("/sprite.png");
		Player_s = load.Loader("/Tom.png");
		Trap_s= load.Loader("/trapMon.png");
		Enemy_s= load.Loader("/monsterr.png");
		
		
		// returns subimage of following images
		pars= new Sprites(Particle_s);
		ps = new Sprites(Player_s);
		ts = new Sprites(Trap_s);
		es = new Sprites(Enemy_s);
		getTexture();
	}
	void getTexture() {
		
		//return image with certain width and height at certain row and coloumn
		num[0]= pars.getImage(1,1,40,40);
		num2[0]= ps.getImage(1, 1, 40, 58);
		
		num3[0]=es.getImage(1, 1, 40, 60);
		num4[0]=ts.getImage(1, 1, 40, 60);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
