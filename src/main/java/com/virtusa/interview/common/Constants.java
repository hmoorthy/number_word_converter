package com.virtusa.interview.common;

public class Constants {

	/**
	 * This utility currently consists of only the NumberToWordConverter, if more
	 * Utility classes are added, the constants in this class maybe useful in
	 * multiple locations. That is why these constants are tracked in a separate
	 * class instead of only in NumberToWordConverter class.
	 */

	public static String SPACE = " ";
	public static String EMPTY = "";
	public static String AND = "and";
	public static String WORD_ZERO = "zero";

	public static String[] placeValues = new String[] { "hundred", "thousand", "million" };

	public static String[] primitiveNumbers = new String[] { "zero", "one", "two", "three", "four", "five", "six",
			"seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "eighteen", "nineteen" };

	public static String multipliersOfTen[] = new String[] { "zero", "ten", "twenty", "thirty", "forty", "fifty",
			"sixty", "seventy", "eighty", "ninety" };

	public static int DIVISOR = 1000;

	public static int ZERO = 0;

	public static int MINUS_ONE = -1;

	public static int TWO = 2;

	public static int THREE = 3;

	public static int TWENTY = 20;

	public static int TEN = 10;

	public static int HUNDRED = 100;

	public static long LIMIT = 999999999;

	public static String INVALID_INPUT = "Invalid input";

	public static String INPUT_MISMATCH = "Long value expected as input";

	public static String INPUT_OUT_OF_BOUNDS = " Input value must not exceed 999 999 999";

}
