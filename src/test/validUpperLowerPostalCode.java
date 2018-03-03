package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class validUpperLowerPostalCode {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private static String lowerCaseFrom;
	private static String upperCaseFrom;
	private static String lowerCaseTo;
	private static String upperCaseTo;
	private static String validPostType;
	private static String validLength;
	private static String validWidth;
	private static String validHeight;
	private static String validWeight;
	
	private static float actualPrice;
	
	@Before
	public void setUp() throws Exception {
		upperCaseFrom = "N4K5N5";
		lowerCaseFrom = upperCaseFrom.toLowerCase();
		upperCaseTo = "P0L1T0";
		lowerCaseTo = upperCaseTo.toLowerCase();
		validPostType = "xpress";
		validLength = "30";
		validWidth = "30";
		validHeight = "30";
		validWeight = "20";
		
		actualPrice = (float) 3.194 * Float.parseFloat(validWeight);
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
		String[] args = {lowerCaseFrom, lowerCaseTo, validPostType, String.valueOf(validLength), String.valueOf(validWidth), String.valueOf(validHeight), String.valueOf(validWeight)};
		
		Calculator.main(args);
		
		assertNotNull(outContent.toString());
		assertEquals(actualPrice, Float.parseFloat(outContent.toString()), 2);
	}
}
