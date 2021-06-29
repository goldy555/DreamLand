package com.log.timmy;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
//class to load image into canvas
public class ImageLoader {
	
	
	private BufferedImage img;
	
	
	public BufferedImage Loader(String loca) {
		//read and return the image from certain file
		try {
			img = ImageIO.read(getClass().getResource(loca));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
		
		
	}

}
