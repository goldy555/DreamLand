package com.log.timmy;

import java.awt.Dimension;
import java.io.Serializable;

import javax.swing.JFrame;

public class Display  {
	
	/**
	 * 
	 */
	//setting up Jframe
	private static final long serialVersionUID = 1L;
	public static final String ID = "Log of Tom's Journey to Dreamland";
	//Color c = new Color(0,150,255);
	public JFrame window;
	
	
	public Display(int width, int height,  Game game) {
		
		game.setPreferredSize(new Dimension(width,height));
		game.setMinimumSize(new Dimension(width,height));
		game.setMaximumSize(new Dimension(width,height));
		window = new JFrame (ID); 
		window.add(game);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
	    window.setVisible(true);
	    
	    game.start();
	}

}
