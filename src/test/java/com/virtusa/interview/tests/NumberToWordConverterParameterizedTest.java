package com.virtusa.interview.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.virtusa.interview.utility.NumberToWordConverter;

@RunWith(Parameterized.class)
public class NumberToWordConverterParameterizedTest {

	private long input;
	private String result;
	private NumberToWordConverter testClass = null;

	@After
	public void after() {
		testClass = null;
	}

	public NumberToWordConverterParameterizedTest(long input, String result) {
		this.input = input;
		this.result = result;
	}

	@Parameters
	public static List<Object[]> data() {
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[] { 234567890,
				"two hundred and thirty four million five hundred and sixty seven thousand eight hundred and ninety" });
		list.add(new Object[] { 900000000, "nine hundred million" });
		list.add(new Object[] { 100200300, "one hundred million two hundred thousand three hundred" });
		list.add(new Object[] { 1001001, "one million one thousand one" });
		list.add(new Object[] { 24503018, "twenty four million five hundred and three thousand eighteen" });
		list.add(new Object[] { 15, "fifteen" });
		list.add(new Object[] { 4, "four" });
		list.add(new Object[] { 300, "three hundred" });
		return list;
	}

	@Test
	public void testMultipleValidInput() {
		testClass = new NumberToWordConverter(input);
		String s = testClass.convertToWord();
//		System.out.println("-"+s+"-");
		assertEquals(result, s);

	}

}
