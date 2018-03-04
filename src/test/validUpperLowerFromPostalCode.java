package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class validUpperLowerFromPostalCode {

	private final DecimalFormat decimal = new DecimalFormat(".##");
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private static String validUpperlowerCaseFrom;
	private static String validTo;
	private static String validPostType;
	private static String validLength;
	private static String validWidth;
	private static String validHeight;
	private static String validWeight;
	
	private static String actualPrice;
	
	@Before
	public void setUp() throws Exception {
		validUpperlowerCaseFrom = "N4k5n5";
		validTo = "P0L1T0";
		validPostType = "xpress";
		validLength = "30";
		validWidth = "30";
		validHeight = "30";
		validWeight = "20";		
		actualPrice = String.valueOf(decimal.format((float) 2.308 * Float.parseFloat(validWeight)));
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
		String[] args = {validUpperlowerCaseFrom, validTo, validPostType, validLength, validWidth,validHeight,validWeight};
		
		Calculator.main(args);
		
		assertEquals(actualPrice, outContent.toString());
	}
}
