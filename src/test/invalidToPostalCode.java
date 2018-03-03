package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class invalidToPostalCode {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private static String validFrom;
	private static String invalidTo;
	private static String validPostType;
	private static String validLength;
	private static String validWidth;
	private static String validHeight;
	private static String validWeight;

	@Before
	public void setUp() throws Exception {
		validFrom = "P0B1L0";
		invalidTo = "My house";
		validPostType = "xpress";
		validLength = "15";
		validWidth = "15";
		validHeight = "15";
		validWeight = "15";
	}

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(System.out);
	    System.setErr(System.err);
	}
	
	@Test
	public void testInvalidToPostalCode() {
		String[] args = {validFrom, invalidTo, validPostType, String.valueOf(validLength), String.valueOf(validWidth), String.valueOf(validHeight), String.valueOf(validWeight)};
		
		Calculator.main(args);
		
		assertEquals("Invalid input: To postal code is invalid.", outContent.toString());
	}

}
