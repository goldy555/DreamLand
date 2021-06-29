package com.log.timmy;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//mouse input for user
public class Mouse implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mousePressed(MouseEvent e) {
		int a = e.getX();
		int b = e.getY();
		//restricting the input to certain area, in case of clicking in that certain area result in following bool/enum variable being set.
		
		if ( a>=Game.WIDTH/2-20 && a<=Game.WIDTH/2+60) {
			
			if (b>=200 && b<=250) {
				
				Game.idn = Identity.START;
		}
		}

		if ( a>=Game.WIDTH/2-20 && a<=Game.WIDTH/2+60) {
			
			if (b>=290 && b<=350) {
				
			Game.scores = true;
		}
		}
		
		
		if ( a>=Game.WIDTH/2-20 && a<=Game.WIDTH/2+60) {
			
			if (b>= 390 && b<=450) {
				
				System.exit(1);
			}
		}
		
		
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
