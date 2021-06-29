package Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.log.timmy.Highscore;
import com.log.timmy.MainMenu;

import junit.framework.Assert;

public class ScoreRelatedTest {
	private Highscore x;
	
	@Before
	public void setUp() {
		
		x = new Highscore(123);
		
	}
	

	@Test
	public void testHighScore() throws IOException {
		int expected =125;
		int actual =0;
		Highscore h = new Highscore(expected);
		Highscore h2 = new Highscore(100);
		int a =0;
		int b=0;
		a=h.tostring();
		b=h2.tostring();
		MainMenu menu= new MainMenu();
		String filename = "yesss.txt";
		File f = new File(filename);
		
		
		FileWriter fw;
			fw = new FileWriter(f, true);
		
		
			fw.write(String.valueOf(a));
	        fw.write("\r\n");
	       fw.write(String.valueOf(b));
	        fw.write("\r\n");
		   fw.flush();
		    fw.close();
		
		actual =menu.High(filename);
		System.out.println(actual);
		
		assertEquals(125, actual);
		
	}
	
	
	
	
	

}
