package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class lessOrEqualToZeroWeight {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();	
	
	private static String validFrom;
	private static String validTo;
	private static String validPostType;
	private static String validLength;
	private static String validWidth;
	private static String validHeight;
	private static String lessOrEqualToZeroWeight;

	@Before
	public void setUp() throws Exception {
		validFrom = "T2P4L4";
		validTo = "T4N5Z9";
		validPostType = "epress";
		validLength = "110";
		validWidth = "100";
		validHeight = "200";
		lessOrEqualToZeroWeight = "-88";
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
		String[] args = {validFrom,validTo,validPostType,validLength,validWidth,validHeight,lessOrEqualToZeroWeight};
	    Calculator.main(args);
	    assertEquals("Your input weight should be bigger than 0", outContent.toString());
	}

}
