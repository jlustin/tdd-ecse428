package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class invalidPostType {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private static String validFrom;
	private static String validTo;
	private static String invalidPostType;
	private static String validLength;
	private static String validWidth;
	private static String validHeight;
	private static String validWeight;

	@Before
	public void setUp() throws Exception {
		validFrom = "m6e1R1";
		validTo = "S4p3y2";
		invalidPostType = "#$%ERFSD&";
		validLength = "14";
		validWidth = "55";
		validHeight = "33";
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
	public void testInvalidPostType() {
		String[] args = {validFrom, validTo, invalidPostType, validLength, validWidth, validHeight, validWeight};
		
		Calculator.main(args);
		
		assertEquals("Invalid input: post type is invalid.", outContent.toString());
	}

}
