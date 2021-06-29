package Test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import com.log.timmy.BaEnemy;
import com.log.timmy.Display;
import com.log.timmy.Entity;
import com.log.timmy.Game;
import com.log.timmy.Identity;
import com.log.timmy.MultiObjects;
import com.log.timmy.Player;
import com.log.timmy.Traps;

public class ObjectCollisionMovementTest {
	private Game gg;
	private MultiObjects mb;
	private LinkedList<Entity> e;

	@Before
	public void setUp() throws Exception {
		gg = new Game();
		
		mb= new MultiObjects();
		
		
	}


	@Test
	public void BasicEnemyMovingtest() {
		
		BaEnemy b = new BaEnemy(100,0,40,60,mb,Identity.SMARTE);
		
		mb.AddEntity(b);
		
		
		mb.Update();
		
	
	int ba= (int) b.getx();
	System.out.println("Position of Basic Enemy as compared to its original Position "+ba);
	
	assertNotEquals (100,ba);
	
		
		
		
		
		
		
		
	}
	
	@Test
	public void TrapMonsterMovementtest() {
		
		Traps Tmon = new Traps(300,0,40,60,mb,Identity.ENEMY);
		
		mb.AddEntity(Tmon);
		
		
		mb.Update();
		
		int c= (int) Tmon.getX();
		
		System.out.println("position of Trapmon as compared to its intial Position " +c);
		assertNotEquals(c<300, c);
		
		
		
	}
	
	@Test
	public void PlayerCollisionWithBAEnemytest() {
		
		
		
		Player p = new Player(100,0,45,60,mb,Identity.PLAYER);
		
	BaEnemy bee = new BaEnemy (100,0,45,60,mb,Identity.SMARTE);
		
		mb.AddEntity(p);
		mb.AddEntity(bee);
		
		mb.Update();
		
		p.Collision(e);
		
		assertTrue(gg.GameOver);
		
		
		
		
		
	}
	
	
	@Test
	public void PlayerCollisionWithTraptest() {
		
		
		
		Player p = new Player(100,0,45,60,mb,Identity.PLAYER);
		
	Traps tee = new Traps (100,0,45,60,mb,Identity.ENEMY);
		
		mb.AddEntity(p);
		mb.AddEntity(tee);
		
		mb.Update();
		
		p.Collision(e);
		
		assertTrue(gg.GameOver);
		
		
		
		
		
	}
	
	
	

}
