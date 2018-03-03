package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class validUpperLowerToPostalCode {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private static String validFrom;
	private static String validUpperlowerCaseTo;
	private static String validPostType;
	private static String validLength;
	private static String validWidth;
	private static String validHeight;
	private static String validWeight;
	
	private static String actualPrice;
	
	@Before
	public void setUp() throws Exception {
		validFrom = "s0a3C0";
		validUpperlowerCaseTo = "g1v3V5";
		validPostType = "priority";
		validLength = "37";
		validWidth = "34";
		validHeight = "44";
		validWeight = "20";		
		actualPrice = String.valueOf((float) 9.835 * Float.parseFloat(validWeight));
	}

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@After
	public void restoreStreams() {
	    System.setOut(System.out);
	    System.setErr(System.err);
	}
	
	@Test
	public void testLowerFromLowerTo() {
		String[] args = {validFrom, validUpperlowerCaseTo, validPostType, validLength, validWidth,validHeight,validWeight};
		
		Calculator.main(args);
		
		assertEquals(actualPrice, outContent.toString());
	}
}
