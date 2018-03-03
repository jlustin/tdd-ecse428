package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class nonExistentFromPostalCode {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private static String nonExistentValidFrom;
	private static String validTo;
	private static String validPostType;
	private static String validLength;
	private static String validWidth;
	private static String validHeight;
	private static String validWeight;
	
	@Before
	public void setUp() throws Exception {
		nonExistentValidFrom = "C9K8A5";
		validTo = "K1L6C7";
		validPostType = "xpress";
		validLength = "100";
		validWidth = "80";
		validHeight = "50";
		validWeight = "30";
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
	public void testNonExistentFromPostalCode() {
		String[] args = {nonExistentValidFrom, validTo, validPostType,validLength,validWidth,validHeight, validWeight};
		
		Calculator.main(args);
		
		assertEquals("Invalid input: From postal code is non-existent in our database.", outContent.toString());
	}

}
