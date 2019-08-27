package com.virtusa.interview.tests;

import static org.junit.Assert.assertEquals;

import java.util.InputMismatchException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import com.virtusa.interview.common.Constants;
import com.virtusa.interview.utility.NumberToWordConverter;

public class NumberToWordConverterFailureTest {

	private NumberToWordConverter testClass = null;

	NumberToWordConverter mock = Mockito.mock(NumberToWordConverter.class);
	//inside test method, Mockito.when(mock.method()).thenReturn(..);

	@BeforeClass
	public static void setup() {

	}

	@AfterClass
	public static void teardown() {
	}

	@Before
	public void before() {
	}

	@After
	public void after() {
		testClass = null;
	}

	
	@Test(expected = NumberFormatException.class)
	public void testNegativeInput() {
		testClass = new NumberToWordConverter(-1L);
		testClass.convertToWord();
	}

	@Test(expected = NumberFormatException.class)
	public void testNullInput() {
		testClass = new NumberToWordConverter(null);
		testClass.convertToWord();
	}

	/**
	 * Creating a rule to verify both exception and exception message
	 */
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testInputUpperLimit() {
		expectedException.expect(InputMismatchException.class);
		expectedException.expectMessage(Constants.INPUT_OUT_OF_BOUNDS);
		testClass = new NumberToWordConverter(1000000000L);
		testClass.convertToWord();

	}

	@Test
	public void testZeroInput() {
		testClass = new NumberToWordConverter(0L);
		assertEquals("zero", testClass.convertToWord());

	}

}
