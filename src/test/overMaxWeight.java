package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class overMaxWeight {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		
	private static String validFrom;
	private static String validTo;
	private static String validPostType;
	private static String validLength;
	private static String validWidth;
	private static String validHeight;
	private static String overMaxWeight;

	@Before
	public void setUp() throws Exception {
		validFrom = "H2B1T6";
		validTo = "l5w0e7";
		validPostType = "priority";
		validLength = "50";
		validWidth = "55";
		validHeight = "35";
		overMaxWeight = "66";
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
		String[] args = {validFrom,validTo,validPostType,validLength,validWidth,validHeight,overMaxWeight};
	    Calculator.main(args);
	    assertEquals("Over Weight, the maximum weight is 30 kg", outContent.toString());
	}

}
