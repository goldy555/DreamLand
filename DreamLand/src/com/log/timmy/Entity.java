package com.log.timmy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.LinkedList;

public abstract class Entity {

	/**
	 * 
	 */
	//entity body (parent class) for different child classes like player, Baenemy, particles etc
	private static final long serialVersionUID = 1L;
	protected Identity ID;
	private double x;
	private double y;
	protected boolean collide = false;
	protected boolean fall  = true;
	protected boolean attack = false;
	protected int flag =0;
	public boolean isAttack() {
		return attack;
	}

	public void setAttack(boolean attack) {
		this.attack = attack;
	}

	public boolean isCollide() {
		return collide;
	}

	public void setCollide(boolean collide) {
		this.collide = collide;
	}

	protected int width, height;
	protected double vx =0, vy=0;
	//constructor with x,y axis, width, height of objext and enum id linked with it.
	public Entity(float x, float y, int width, int height, Identity ID) {
		
		this.setX(x);
		this.setY(y);
		this.width=width;
		this.height = height;
		this.ID=ID;
		
		
	}
	//various setter and getters and abstract render and update function for child classes.
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void update(LinkedList <Entity> entity);
	public abstract void render (Graphics g);
	public abstract Rectangle getBounds();
	public Identity GetID() {
		return ID;
	}

	public double getx() {
		return getX();
	}

	public void setx(float x) {
		this.setX(x);
	}

	public double gety() {
		return getY();
	}

	public void sety(float y) {
		this.setY(y);
	}

	public double getVx() {
		return vx;
	}

	public void setVx(float vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(float vy) {
		this.vy = vy;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}


	

	
}
