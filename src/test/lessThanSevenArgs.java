package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class lessThanSevenArgs {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	private String arg1;
	private String arg2;
	private String arg3;
	private String arg4;
	private String arg5;
	
	@Before
	public void setUp() {
		arg1 = "H2B1T6";
		arg2 = "L5W0E7";
		arg3 = "priority";
		arg4 = "50";
		arg5 = "50";
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
	public void testLessThanSevenArgs() {
		String[] args = {arg1, arg2, arg3, arg4, arg5};
	    Calculator.main(args);
	    assertEquals("Usage: Calculator fromPostalCode toPostalCode postType length width height weight", outContent.toString());
	}
}
