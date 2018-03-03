package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class validUpperLowerPostType {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private static Calculator postalRate;
	
	private static String validFrom;
	private static String validTo;
	private static String upperCasePostType;
	private static String validLength;
	private static String validWidth;
	private static String validHeight;
	private static String validWeight;
	
	private static float actualPrice;
	
	@Before
	public void setUp() throws Exception {
		validFrom = "H2B1T6";
		validTo = "L5W0E7";
		upperCasePostType = "PriOritY";
		validLength = "50";
		validWidth = "50";
		validHeight = "50";
		validWeight = "15";
		
		actualPrice = (float) 2.683 * Float.parseFloat(validWeight);
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
	public void testLowercasePostType() {
		String[] args = {validFrom, validTo, upperCasePostType, String.valueOf(validLength), String.valueOf(validWidth), String.valueOf(validHeight), String.valueOf(validWeight)};
		
		Calculator.main(args);
		
		assertNotNull(outContent.toString());
		assertEquals(actualPrice, Float.parseFloat(outContent.toString()), 2);
	}
}
