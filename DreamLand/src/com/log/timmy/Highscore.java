package com.log.timmy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Highscore implements Serializable {
//serializable class
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int a;

		public Highscore(int a) {
			
			this.a = a;
		}
		
		
		public int tostring() {
			return a;
			
			
		}
		

}
	
	
	
	    