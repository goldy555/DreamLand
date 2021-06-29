package com.log.timmy;

import java.io.Serializable;

public class Camera{
	/**
	 * 
	 */
	//camera class whose object follows player on x axis
	private static final long serialVersionUID = 1L;
	int x,y;
	public Camera(int x, int y){
		this.x=x;
		this.y=y;
		
		
	}
	public void update( Entity Player) {
		//algo that follow player(moves  screen)
		x = (int) (-Player.getx()+Game.WIDTH);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
