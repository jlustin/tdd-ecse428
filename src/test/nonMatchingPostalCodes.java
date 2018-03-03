package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class nonMatchingPostalCodes {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private static String validFrom;
	private static String validTo;
	private static String validPostType;
	private static String validLength;
	private static String validWidth;
	private static String validHeight;
	private static String validWeight;
	
	@Before
	public void setUp() throws Exception {
		validFrom = "H2B1T6";
		validTo = "M4W1J7";
		validPostType = "priority";
		validLength = "50";
		validWidth = "60";
		validHeight = "10";
		validWeight = "24";
		
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
	public void testNonMatchingPostalCodes() {
		String[] args = {validFrom, validTo, validPostType,validLength,validWidth,validHeight,validWeight};
		
		Calculator.main(args);
		
		assertEquals("Entered From and To postal codes do not match in our database.", outContent.toString());
	}

}
