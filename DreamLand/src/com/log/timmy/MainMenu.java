package com.log.timmy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MainMenu {
	///main menu HUD class with following drawing of tabs
	
	public Rectangle play = new Rectangle (Game.WIDTH/2-60, 170, 140,60 );

	public Rectangle Load = new Rectangle (Game.WIDTH/2-60, 290, 140,60 );
	public Rectangle Quit = new Rectangle (Game.WIDTH/2-60, 390, 140,60 );
	
	
	public void render (Graphics gr) {
		
	
		
		
		
		Graphics2D g2d = (Graphics2D)gr;
		Font f = new Font (Font.MONOSPACED, Font.BOLD, 40 );
		
		gr.setFont(f);
		
		gr.setColor(Color.WHITE);
		
		gr.drawString(" The DreamLand", 220, 100);
		g2d.setColor(Color.GRAY);
		g2d.fillRect(Game.WIDTH/2-80, 190, 180,60);	
		g2d.fillRect(Game.WIDTH/2-88, 290, 260,60);
		g2d.fillRect(Game.WIDTH/2-80, 390, 180,60);
		g2d.setColor(Color.GREEN);
		gr.drawString("Play", Game.WIDTH/2-30, 240);
		gr.drawString("Quit", Game.WIDTH/2-40, 440);
		gr.drawString("HighScore", Game.WIDTH/2-60, 330);
		
	
		
		
		
		
	}
	//display game over
	public void gameover(Graphics gr) {
		Graphics2D g2d = (Graphics2D)gr;
		Font f = new Font (Font.MONOSPACED, Font.BOLD, 40 );
		
		gr.setFont(f);
		
		gr.setColor(Color.WHITE);
		
		gr.drawString(" GameOver",220,100);
		g2d.setColor(Color.GRAY);
			
			
		
		
		
	}
	
	
	public int High(String se) throws FileNotFoundException {
		int x =0;
		File file = new File (se);
		Scanner s = new Scanner(file);
		int [] arr = new int [1000];
		int i=0;
		
		for ( i=0; s.hasNextInt();i++) {
			
			
			arr[i]=s.nextInt();
			
			if (x<arr[i]) {
				
				x=arr[i];
			}
		
		
	}
	
	
	return x;
	
}
	
	
	
	
	//display player score in screen at end of game/gameover
	public void SC(Graphics gr, int a) {
		
		Graphics2D g2d = (Graphics2D)gr;
		Font f = new Font (Font.MONOSPACED, Font.BOLD, 40 );
		
		gr.setFont(f);
		
		gr.setColor(Color.PINK);
		
		gr.drawString("Your Score is: "+ a,Game.a - 220,350);
		g2d.setColor(Color.GRAY);
		
		
		
	}
	

	
	
}
	/*

	

	
}
	
	*/

