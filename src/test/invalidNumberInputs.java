package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class invalidNumberInputs {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private static String validFrom;
	private static String validTo;
	private static String validPostType;
	private static String invalidLength;
	private static String invalidWidth;
	private static String invalidHeight;
	private static String invalidWeight;


	@Before
	public void setUp() throws Exception {
		validFrom = "P0B1L0P";
		validTo = "H4A1H3";
		validPostType = "xpress";
		invalidLength = "sss";
		invalidWidth = "1#as";
		invalidHeight = "1awe$%5";
		invalidWeight = "nihao";
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
	public void testInvalidNumberInputs() {
		String[] args = {validFrom, validTo, validPostType, invalidLength, invalidWidth, invalidHeight, invalidWeight};
		
		Calculator.main(args);
		
		assertEquals("Invalid input: length, width, height or weight is/are invalid.", outContent.toString());
	}

}
