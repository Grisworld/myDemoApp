package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    /*public AppTest( String testName )
    {
        super( );
    }

    /**
     * @return the suite of tests being tested
     
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     
    public void testApp()
    {
        assertTrue( true );
    }
    */
	
    	    public void testfindBiggerOfSME() { //Equal
		  ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4,1));
		  ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
	      	  assertTrue(154==App.findBiggerOfSM(array,array2,"Berkehan Salli","Koray Demir"));
	    }
		
	    public void testfindBiggerOfSM() { //Negative
	      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
	      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
	      assertFalse(-2==App.findBiggerOfSM(array,array2,"Oguz","Suleyman"));
	    }
		
	    public void testEmptyStringsandArray() {
	      ArrayList<Integer> array = new ArrayList<>();
	      ArrayList<Integer> array2 = new ArrayList<>();
	      assertTrue(0==App.findBiggerOfSM(array,array2, "",""));
	    }
		
	    public void testNull() {
	      assertTrue(-1==App.findBiggerOfSM(new ArrayList<Integer>(),null,"23" ,"31"));
	    }
	    public void testFindSumH() { //Find the highest one
	      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4,10));
	      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(5,6,7,8,50));
	      assertTrue(1520==App.findBiggerOfSM(array,array2,"Furkan Danismaz","Umutcan Kaymaz"));
	    }
	
}
