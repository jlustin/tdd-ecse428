package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class validInputTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private static Calculator postalRate;
	
	private static String validFrom;
	private static String validTo;
	private static String validPostType;
	private static String validLength;
	private static String validWidth;
	private static String validHeight;
	private static String validWeight;
	
	private static float actualPrice;
	
	@Before
	public void setUp() throws Exception {
		validFrom = "P0B1L0";
		validTo = "H4A1H3";
		validPostType = "xpress";
		validLength = "15";
		validWidth = "15";
		validHeight = "15";
		validWeight = "15";
		
		actualPrice = (float) 1.79 * Float.parseFloat(validWeight);
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
	public void testValidInput() {
		String[] args = {validFrom, validTo, validPostType, String.valueOf(validLength), String.valueOf(validWidth), String.valueOf(validHeight), String.valueOf(validWeight)};
		
		Calculator.main(args);
		
		assertNotNull(outContent.toString());
		assertEquals(actualPrice, Float.parseFloat(outContent.toString()), 2);
	}

}
