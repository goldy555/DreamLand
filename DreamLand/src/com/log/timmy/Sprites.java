package com.log.timmy;

import java.awt.image.BufferedImage;
//this class returns a subimage defined by the rectangular region of certain img.
public class Sprites {

	private BufferedImage img;
	
	
	public Sprites(BufferedImage img) {
		this.img =img;
	
		
	}
	
	
	public BufferedImage getImage(int c, int r, int w, int h) {
		BufferedImage imga = img.getSubimage((c*w)-w, (r*h)-h, w, h);
		return imga;
		
		
		
		
	}
	
}
