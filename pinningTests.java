/*
 * Author: Neel Kowdley <nkowdley@gmail.com>
 * Class: CS1632
 * Deliverable 5: SlowCodeGUI
 * File: pinningTests.java
 * Description: These are a set of JUnit Tests to verify that refactoring methods 
 * in the source code yield the same results
 * */
import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Random;

import org.junit.Test;


public class pinningTests {

	/*Initialize the main panel for unit tests--this needs to be global b/c to use a thread to test runContinuous*/
	MainPanel mp = new MainPanel(10);
	
	@Test
	public void convertToIntTest() {
		/*for some 100 random inputs, test that convertToInt and the refactored newConvertToInt are identical*/
		MainPanel mp_zero = new MainPanel('0'); /*create a new MainPanel with a size of 0*/
		Random r = new Random();/*initialize the random*/
		for (int i=0;i<100;i++)
		{
			int testInt=r.nextInt(Integer.MAX_VALUE); /*get some random positive int, as the original does not work with negatives*/
			assertEquals(mp_zero.OldConvertToInt(testInt),mp_zero.convertToInt(testInt));
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
	
	/*Verify that run continuous works, by simulating a configuration which should result in a stable pattern after some
	 * amount of iterations*/
	@Test
	public void runContSetUp() throws InterruptedException{
		for(int i=0;i<6;i++)
		{
			mp._cells[6][i].setAlive(true);
		}
		//System.out.println(mp.toString());
		(new Thread(new GameRunnable())).start(); /*Initialize a thread to start runContinuous*/
		Thread.sleep(10000);/*allow the runContinuous to run for 10 seconds*/
		mp.stop();/*stop the panel*/
		Thread.sleep(2000);/*sleep for 2 seconds to verify the mp has stopped*/
		/*Verify that the cells match the button color*/
		runContTest();		
		mp.clear();
		for(int i=0;i<6;i++)
		{
			mp._cells[6][i].setAlive(true);
		}
		(new Thread(new OldGameRunnable())).start(); /*Initialize a thread to start runContinuous*/
		Thread.sleep(10000);/*allow the runContinuous to run for 10 seconds*/
		mp.stop();/*stop the panel*/
		Thread.sleep(2000);/*sleep for 2 seconds to verify the mp has stopped*/
		/*Verify that the cells match the button color*/
		runContTest();		
	}
	/*Verify that the matrix looks as we intend it to look.*/
	public void runContTest(){
		/*Zero Row*/
		assertEquals(mp._cells[0][0].getBackground(),Color.GRAY);
		assertEquals(mp._cells[0][1].getBackground(),Color.GRAY);
		assertEquals(mp._cells[0][2].getBackground(),Color.GRAY);
		assertEquals(mp._cells[0][3].getBackground(),Color.GRAY);
		assertEquals(mp._cells[0][4].getBackground(),Color.GRAY);
		assertEquals(mp._cells[0][5].getBackground(),Color.GRAY);
		assertEquals(mp._cells[0][6].getBackground(),Color.GRAY);
		assertEquals(mp._cells[0][7].getBackground(),Color.GRAY);
		assertEquals(mp._cells[0][8].getBackground(),Color.GRAY);
		assertEquals(mp._cells[0][9].getBackground(),Color.GRAY);
		/*One Row*/
		assertEquals(mp._cells[1][0].getBackground(),Color.GRAY);
		assertEquals(mp._cells[1][1].getBackground(),Color.GRAY);
		assertEquals(mp._cells[1][2].getBackground(),Color.GRAY);
		assertEquals(mp._cells[1][3].getBackground(),Color.GRAY);
		assertEquals(mp._cells[1][4].getBackground(),Color.GRAY);
		assertEquals(mp._cells[1][5].getBackground(),Color.GRAY);
		assertEquals(mp._cells[1][6].getBackground(),Color.GRAY);
		assertEquals(mp._cells[1][7].getBackground(),Color.GRAY);
		assertEquals(mp._cells[1][8].getBackground(),Color.GRAY);
		assertEquals(mp._cells[1][9].getBackground(),Color.GRAY);
		/*Two Row*/
		assertEquals(mp._cells[2][0].getBackground(),Color.GRAY);
		assertEquals(mp._cells[2][1].getBackground(),Color.GRAY);
		assertEquals(mp._cells[2][2].getBackground(),Color.GRAY);
		assertEquals(mp._cells[2][3].getBackground(),Color.GRAY);
		assertEquals(mp._cells[2][4].getBackground(),Color.GRAY);
		assertEquals(mp._cells[2][5].getBackground(),Color.GRAY);
		assertEquals(mp._cells[2][6].getBackground(),Color.GRAY);
		assertEquals(mp._cells[2][7].getBackground(),Color.GRAY);
		assertEquals(mp._cells[2][8].getBackground(),Color.GRAY);
		assertEquals(mp._cells[2][9].getBackground(),Color.GRAY);
		/*Three Row*/
		assertEquals(mp._cells[3][0].getBackground(),Color.GRAY);
		assertEquals(mp._cells[3][1].getBackground(),Color.GRAY);
		assertEquals(mp._cells[3][2].getBackground(),Color.GRAY);
		assertEquals(mp._cells[3][3].getBackground(),Color.GRAY);
		assertEquals(mp._cells[3][4].getBackground(),Color.GRAY);
		assertEquals(mp._cells[3][5].getBackground(),Color.GRAY);
		assertEquals(mp._cells[3][6].getBackground(),Color.GREEN);
		assertEquals(mp._cells[3][7].getBackground(),Color.GREEN);
		assertEquals(mp._cells[3][8].getBackground(),Color.GREEN);
		assertEquals(mp._cells[3][9].getBackground(),Color.GREEN);
		/*Four Row*/
		assertEquals(mp._cells[4][0].getBackground(),Color.GRAY);
		assertEquals(mp._cells[4][1].getBackground(),Color.GREEN);
		assertEquals(mp._cells[4][2].getBackground(),Color.GREEN);
		assertEquals(mp._cells[4][3].getBackground(),Color.GREEN);
		assertEquals(mp._cells[4][4].getBackground(),Color.GREEN);
		assertEquals(mp._cells[4][5].getBackground(),Color.GRAY);
		assertEquals(mp._cells[4][6].getBackground(),Color.GREEN);
		assertEquals(mp._cells[4][7].getBackground(),Color.GREEN);
		assertEquals(mp._cells[4][8].getBackground(),Color.GREEN);
		assertEquals(mp._cells[4][9].getBackground(),Color.GREEN);
		/*Five Row*/
		assertEquals(mp._cells[5][0].getBackground(),Color.GREEN);
		assertEquals(mp._cells[5][1].getBackground(),Color.GREEN);
		assertEquals(mp._cells[5][2].getBackground(),Color.GREEN);
		assertEquals(mp._cells[5][3].getBackground(),Color.GREEN);
		assertEquals(mp._cells[5][4].getBackground(),Color.GREEN);
		assertEquals(mp._cells[5][5].getBackground(),Color.GREEN);
		assertEquals(mp._cells[5][6].getBackground(),Color.GREEN);
		assertEquals(mp._cells[5][7].getBackground(),Color.GREEN);
		assertEquals(mp._cells[5][8].getBackground(),Color.GREEN);
		assertEquals(mp._cells[5][9].getBackground(),Color.GREEN);
		/*Six Row*/
		assertEquals(mp._cells[6][0].getBackground(),Color.GREEN);
		assertEquals(mp._cells[6][1].getBackground(),Color.GREEN);
		assertEquals(mp._cells[6][2].getBackground(),Color.GREEN);
		assertEquals(mp._cells[6][3].getBackground(),Color.GREEN);
		assertEquals(mp._cells[6][4].getBackground(),Color.GREEN);
		assertEquals(mp._cells[6][5].getBackground(),Color.GREEN);
		assertEquals(mp._cells[6][6].getBackground(),Color.GREEN);
		assertEquals(mp._cells[6][7].getBackground(),Color.GREEN);
		assertEquals(mp._cells[6][8].getBackground(),Color.GREEN);
		assertEquals(mp._cells[6][9].getBackground(),Color.GREEN);
		/*Seven Row*/
		assertEquals(mp._cells[7][0].getBackground(),Color.GREEN);
		assertEquals(mp._cells[7][1].getBackground(),Color.GREEN);
		assertEquals(mp._cells[7][2].getBackground(),Color.GREEN);
		assertEquals(mp._cells[7][3].getBackground(),Color.GREEN);
		assertEquals(mp._cells[7][4].getBackground(),Color.GREEN);
		assertEquals(mp._cells[7][5].getBackground(),Color.GREEN);
		assertEquals(mp._cells[7][6].getBackground(),Color.GREEN);
		assertEquals(mp._cells[7][7].getBackground(),Color.GREEN);
		assertEquals(mp._cells[7][8].getBackground(),Color.GREEN);
		assertEquals(mp._cells[7][9].getBackground(),Color.GREEN);
		/*Eight Row*/
		assertEquals(mp._cells[8][0].getBackground(),Color.GRAY);
		assertEquals(mp._cells[8][1].getBackground(),Color.GREEN);
		assertEquals(mp._cells[8][2].getBackground(),Color.GREEN);
		assertEquals(mp._cells[8][3].getBackground(),Color.GREEN);
		assertEquals(mp._cells[8][4].getBackground(),Color.GREEN);
		assertEquals(mp._cells[8][5].getBackground(),Color.GRAY);
		assertEquals(mp._cells[8][6].getBackground(),Color.GREEN);
		assertEquals(mp._cells[8][7].getBackground(),Color.GREEN);
		assertEquals(mp._cells[8][8].getBackground(),Color.GREEN);
		assertEquals(mp._cells[8][9].getBackground(),Color.GREEN);
		/*Nine Row*/
		assertEquals(mp._cells[9][0].getBackground(),Color.GRAY);
		assertEquals(mp._cells[9][1].getBackground(),Color.GRAY);
		assertEquals(mp._cells[9][2].getBackground(),Color.GRAY);
		assertEquals(mp._cells[9][3].getBackground(),Color.GRAY);
		assertEquals(mp._cells[9][4].getBackground(),Color.GRAY);
		assertEquals(mp._cells[9][5].getBackground(),Color.GRAY);
		assertEquals(mp._cells[9][6].getBackground(),Color.GREEN);
		assertEquals(mp._cells[9][7].getBackground(),Color.GREEN);
		assertEquals(mp._cells[9][8].getBackground(),Color.GREEN);
		assertEquals(mp._cells[9][9].getBackground(),Color.GREEN);
	}
		
    class GameRunnable implements Runnable {
	public void run() {
		mp.runContinuous();
		}
    }
    class OldGameRunnable implements Runnable {
	public void run() {
		mp.oldRunContinuous();
		}
    }
}