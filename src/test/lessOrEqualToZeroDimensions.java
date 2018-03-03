package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class lessOrEqualToZeroDimensions {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private static String validFrom;
	private static String validTo;
	private static String validPostType;
	private static String lessOrEqualToZeroLength;
	private static String lessOrEqualToZeroWidth;
	private static String lessOrEqualToZeroHeight;
	private static String validWeight;

	@Before
	public void setUp() throws Exception {
		validFrom = "L5L3A1";
		validTo = "G1V3V5";
		validPostType = "epress";
		lessOrEqualToZeroLength = "0";
		lessOrEqualToZeroWidth = "-12";
		lessOrEqualToZeroHeight = "-44";
		validWeight = "-88";
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
		String[] args = {validFrom,validTo,validPostType,lessOrEqualToZeroLength,lessOrEqualToZeroWidth,lessOrEqualToZeroHeight,validWeight};
		
	    Calculator.main(args);
	    
	    assertEquals("Your input dimensions should be bigger than 0", outContent.toString());
	}

}
