/*
 * Author: Neel Kowdley <nkowdley@gmail.com>
 * Class: CS1632
 * Deliverable 5: SlowCodeGUI
 * File: pinningTests.java
 * Description: These are a set of JUnit Tests to verify that refactoring methods 
 * in the source code yield the same results
 * */
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class pinningTests {

	@Test
	public void convertToIntTest() {
		/*for some 100 random inputs, test that convertToInt and the refactored newConvertToInt are identical*/
		MainPanel mp = new MainPanel('0'); /*create a new MainPanel with a size of 0*/
		Random r = new Random();/*initialize the random*/
		for (int i=0;i<100;i++)
		{
			int testInt=r.nextInt(Integer.MAX_VALUE); /*get some random positive int, as the original does not work with negatives*/
			assertEquals(mp.OldConvertToInt(testInt),mp.convertToInt(testInt));
		}
	}
	@Test
	public void toStringTest(){
		Cell c= new Cell();
		/*Test if a newly initialized Cell returns the same result*/
		assertEquals(c.OldToString(),c.toString());
		/*Set the cell to dead, and verify the returns are the same*/
		c.setAlive(false);
		assertEquals(c.OldToString(),c.toString());
		/*Set the cell to alive, and verify the returns are the same*/
		c.setAlive(true);
		assertEquals(c.OldToString(),c.toString());
		/*Set the cell to dead again, and verify the returns are the same*/
		c.setAlive(false);
		assertEquals(c.OldToString(),c.toString());
			
	}

}
