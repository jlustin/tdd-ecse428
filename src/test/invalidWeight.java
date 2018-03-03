package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class invalidWeight {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private static String validFrom;
	private static String validTo;
	private static String validPostType;
	private static String validLength;
	private static String validWidth;
	private static String validHeight;
	private static String invalidWeight;

	@Before
	public void setUp() throws Exception {
		validFrom = "n4k5n5";
		validTo = "p0l1t0";
		validPostType = "xpress";
		validLength = "66";
		validWidth = "55";
		validHeight = "44";
		invalidWeight = "Rr6#$%^";
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
	public void test() {
		String[] args = {validFrom, validTo, validPostType, validLength, validWidth, validHeight, invalidWeight};
		
		Calculator.main(args);
		
		assertEquals("Invalid input: weight is invalid.", outContent.toString());
	}

}
