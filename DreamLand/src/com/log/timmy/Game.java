package com.log.timmy;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Game extends Canvas implements Runnable{

	/**
	 * 
	 */
	
	
	///different Variables, bools etc..
	private static final long serialVersionUID = 1L;
	public Boolean working = true;
	public static Boolean GameOver = false;
	public static Boolean scores = false;
	public static Boolean Loadstate = false;
	public static Boolean flag = true;
	public static Boolean flag2= true;
	public static Texture t;
	public static int a=0;
private static int scor = 0;
private static int max =0;


	private int HighScoreAlgo=0;
	private static int count =0;
	private static int time =0;
	private Highscore hs; 
	private Thread thread;
	private MainMenu menu;
	public static int  WIDTH,HEIGHT;
	public static Identity idn = Identity.MENU;
	private int co=0;
	Color c = new Color(0,150,255);
	MultiObjects mb;
	Camera cam;
	Random r = new Random();
	
	//Objects intialization/ creation in the fuction methods
	private void methods() {
		
		mb = new MultiObjects();
	
	WIDTH =	getWidth();
	HEIGHT = getHeight();
	menu = new MainMenu();
	t= new Texture();
	mb.AddEntity(new Player(100,100,20, 40, mb,Identity.PLAYER));
	
	mb.AddEntity(new BaEnemy(526,540,20,40,mb,Identity.SMARTE));
	for (int i=0; i<4; i++) {
	mb.AddEntity(new Traps (WIDTH*3+co,150,20,40,mb,Identity.ENEMY));
	co+=100;
	}
	mb.World();
	cam = new Camera(0,0);
	this.addKeyListener(new Keys(mb));
	this.addMouseListener(new Mouse());
	
	}
	//Start of the thread
	public synchronized void start() {
		if (working)
		thread = new Thread(this);
		thread.start();
		
		
	}
	
	//Game loop of the game pumping 60 tics per sec 
	public void run() {
		methods();
		long pastTime= System.nanoTime();
		long pastmilTime = System.currentTimeMillis();
		final double FPS= 60;
		final double optimalFps= (1000000000D / FPS);
		int frames=0;
		double alpha =0;
		int update =0;
		
		while (working) {
			
			

			long presentTime =  System.nanoTime();
			double updateTime = (presentTime - pastTime)/optimalFps;	
			alpha += updateTime;
		pastTime = presentTime;
			while (alpha>=1) {
			update++;
			alpha--;
			tick(); // calling tick function which update objects 
			}
			try {
				render();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frames++;
			
			
			if (System.currentTimeMillis()-pastmilTime>1000) {
				pastmilTime+=1000;
				count++;
				System.out.println("Frames"+frames+"   "+"tics"+update+"   "+count);
				if (Loadstate) {
					
					
					break;
				}
				
				frames=0;
				update=0;
				
			}
			
			
			
		}	
		
		}	
	//Updating multiple object every sec/time game loop runs....
	private void tick() {
		if (idn == idn.START) {
		mb.Update();
		for(int i=0; i<mb.entity.size(); i++) {
			if (mb.entity.get(i).GetID()==Identity.PLAYER) {
			cam.update(mb.entity.get(i));
		}
		}
	
		}
	}
	
	//rendering the graphics/objects and various algorithm like highscore, GameOver etc..
	private void render() throws Exception {
		BufferStrategy bust = this.getBufferStrategy();
		if (bust==null) {
			this.createBufferStrategy(3);
			return;
			
			
		}
	
		Graphics gr =bust.getDrawGraphics();
		Graphics g2d = gr;
		//////////////
		
		
		
		
		gr.setColor(c);
		gr.fillRect(0,0,getWidth(),getHeight());
		g2d.translate(cam.getX(), cam.getY()); // camera begins;    
		
		
		//various emun and bool variable inside if syntax in case which get true will result in start, quit, gameover, highscore
		if (idn==idn.START) {
		mb.Render(gr);
		}
		
		
		
		if (GameOver) {
		
			
			Font f = new Font (Font.MONOSPACED, Font.BOLD, 80 );
			
			gr.setFont(f);
			
			gr.setColor(Color.BLACK);
	
			
			
		
			
			time = count;
			//highscore algorithm
			HighScoreAlgo =600/time;
			
			if (flag) {
			scor = 40 + HighScoreAlgo;
			flag = false;
			}
			
			
			Loadstate=true;
		
			
			
		}
		
		if (Loadstate) {
			
		
			gr.drawString(" GameOver!",a-100,100);
			
			gr.drawString("Press Escape to Exit", a-300, 300);
		
		//using serialization to store the score and then using deserialization to deserailize it and print it in screen.
		
		hs = new Highscore(scor);
		
			try {
			FileOutputStream fo = new FileOutputStream ("YESSS");
			
			ObjectOutputStream os = new ObjectOutputStream(fo);
				
				os.writeObject(hs);
		
		os.close();
		fo.close();
		System.out.println("Saved");
		
		}
			catch(IOException i) {
				
				i.printStackTrace();
			}
			
			 FileInputStream fi = new FileInputStream ("YESSS");
				
				ObjectInputStream oi = new ObjectInputStream(fi);
				Highscore hs =  (Highscore)oi.readObject();
				oi.close();	
				
				menu.SC(gr, hs.tostring());
				
				//Using the file library to store the various score into the file
				
				File file = new File ("HighScore.txt");
			if (flag2) {
				
				
			FileWriter fw = new FileWriter(file, true);
			fw.write(String.valueOf(scor));
fw.write("\r\n");
			fw.flush();
			fw.close();
			flag2 = false;
			
			}
	
			
		
		}
	//algo to find the highest number inside the file then displaying it in screen in case user clicks Highscore tab 
		if (scores) {
			String filename = "Highscore.txt";
		max=menu.High(filename);
			Font f = new Font (Font.MONOSPACED, Font.BOLD, 40 );
			
			gr.setFont(f);
			
			gr.setColor(Color.PINK);
			
			gr.drawString("High Score is:"+max,220,300);
			g2d.setColor(Color.GRAY);
			
		}
		
		
		

		
		else if (idn == idn.MENU) {
			
			menu.render(gr);
			
		}
		
		///////////
		
		g2d.translate(-cam.getX(), -cam.getY());// camera ends;
		System.out.println(-cam.getX());
		///////
		gr.dispose();
		bust.show();
		
	}
	public static Texture getInst() {
		return t;
		
	}
	
	public void stop() {
		
		working = false;
		 
	}
	public static void main(String[] args) {
		new Display(800,600,new Game());

	}

	

}
