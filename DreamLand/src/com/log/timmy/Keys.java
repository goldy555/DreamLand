package com.log.timmy;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
//keyboard input class
public class Keys extends KeyAdapter{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MultiObjects mb;
	
	

	public Keys(MultiObjects mb) {
		
		this.mb = mb;
	}


	
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		//only runs in case user clicks on Start tab
		if (Game.idn == Game.idn.START) {
			
		for (int i=0; i<mb.entity.size(); i++) {
			Entity temp = mb.entity.get(i);
			//if the entity is player then following key input will be used.
			if (temp.GetID()==Identity.PLAYER) {
		if (k==KeyEvent.VK_D){
			temp.setVx(4);
			System.out.println("kdj");
		}
		if (k==KeyEvent.VK_A)
		{
			temp.setVx(-4);
		}
		if (k== KeyEvent.VK_SPACE && !temp.isCollide()) {
			temp.setCollide(true);
			temp.setVy(-4);
			
			
		}
		if (Game.GameOver) {
		if (k== KeyEvent.VK_ESCAPE) {
			
				System.exit(1);
				
			}
		
		}
		
		
			}	
			
			}
		
		}
	}

	public void keyReleased(KeyEvent e) {
		//same as above
		int k = e.getKeyCode();
		for (int i=0; i<mb.entity.size(); i++) {
			Entity tempen = mb.entity.get(i);
			
			if (tempen.GetID()==Identity.PLAYER) {
		if (k==KeyEvent.VK_D){
			tempen.setVx(0);
		
			
		}
		if (k==KeyEvent.VK_A)
		{
			tempen.setVx(0);
		}
		if (k== KeyEvent.VK_SPACE) {
			tempen.setVy(0);
			
		}
	
			}	
			
			}
	}
	
	
	
	

}
