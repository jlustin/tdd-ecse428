package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class overMaxDimensions {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private static Calculator postalRate;
	
	private static String validFrom;
	private static String validTo;
	private static String validPostType;
	private static String overMaxLength;
	private static String overMaxWidth;
	private static String overMaxHeight;
	private static String validWeight;

	@Before
	public void setUp() throws Exception {
		validFrom = "m8z4H4";
		validTo = "T0g0p0";
		validPostType = "REGULAR";
		overMaxLength = "110";
		overMaxWidth = "100";
		overMaxHeight = "200";
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
	public void test() {
		String[] args = {validFrom,validTo,validPostType,overMaxLength,overMaxWidth,overMaxHeight,validWeight};
	    Calculator.main(args);
	    assertEquals("Over Dimensions, the maximum length is 100 cm, the maximum width is 80cm and the maximum height is 50 cm", outContent.toString());
	}

}
