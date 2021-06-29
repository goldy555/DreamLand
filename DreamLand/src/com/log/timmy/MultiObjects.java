package com.log.timmy;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.LinkedList;

public class MultiObjects {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LinkedList <Entity>entity = new LinkedList<Entity>();
	private Entity tempEntity;
	
	
	
	public void Update() {
	for(int i=0; i<entity.size(); i++) {
		
		tempEntity = entity.get(i);
		tempEntity.update(entity);
	
	}
	}
	
	public void Render( Graphics g) {
		for(int i=0; i<entity.size(); i++) {
			
			tempEntity = entity.get(i);
			tempEntity.render(g);
		
		}
	
	
	}
	
	//adds a entity child object ( player, traps, baenemy etc)
	public void AddEntity(Entity entity) {
		this.entity.add(entity);
		
	}
	public void deleteEntity(Entity entity) {
		this.entity.remove(entity);
		
	}
	//World structure or map coding.
	public void World() {
		
		for (int i=0; i<Game.HEIGHT+20; i+=20) {
			AddEntity(new Particle (0, i, 32, 32, Identity.PARTICLE));
			
		}
		
		///i is x axis
		for (int i =Game.WIDTH*3-40; i<Game.WIDTH*3+400; i+=20) {
			AddEntity(new Particle (i, Game.HEIGHT-500, 32, 32, Identity.PARTICLE));
			
		}
		///game height is y axis
		for (int i =0; i<Game.WIDTH*5; i+=20) {
			AddEntity(new Particle (i, Game.HEIGHT, 32, 32, Identity.PARTICLE));
			
		}
		
	
		
		
		for (int i =Game.WIDTH*2+60; i<Game.WIDTH*2+200; i+=20) {
			AddEntity(new Particle (i, Game.HEIGHT-200, 32, 32, Identity.PARTICLE));
			
		}
		for (int i =Game.HEIGHT; i>Game.HEIGHT-140; i-=20) {
			AddEntity(new Particle (500, i, 32, 32, Identity.PARTICLE));
			
		}
		for (int i =Game.HEIGHT; i>Game.HEIGHT-140; i-=20) {
			AddEntity(new Particle (Game.HEIGHT+300, i, 32, 32, Identity.PARTICLE));
			
		}
		for (int i=0; i<Game.HEIGHT+20; i+=20) {
			AddEntity(new Particle (Game.WIDTH*5, i, 32, 32, Identity.PARTICLE));
			
		}	
	
		
		
	}
	
	
	
}
