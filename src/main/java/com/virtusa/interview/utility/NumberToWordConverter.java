package com.virtusa.interview.utility;

import java.util.InputMismatchException;

import com.virtusa.interview.common.Constants;

public class NumberToWordConverter {

	private Long num;

	/**
	 * Calling this class constructor without any numeric argument is pointless,
	 * hence, this constructor
	 * 
	 * @param num
	 */

	public NumberToWordConverter(Long num) {
		// Validate num for null && negative numbers
		if (num == null || num.longValue() < Constants.ZERO) {
			throw new NumberFormatException(Constants.INVALID_INPUT);
		}
		// The instruction given specified the upper limit as 999 999 999, else,
		// placeValues can be extended to billion, trillion, ...
		if (num > Constants.LIMIT) {
			throw new InputMismatchException(Constants.INPUT_OUT_OF_BOUNDS);
		}
		this.num = num;
	}

	public String convertToWord() {
		return reduceToPlaceValues();
	}

	/**
	 * As any given number is identified by placeValues( hundreds, thousands,
	 * millions) of upto 3 digits each, this method segregates the given number into
	 * its placeValue positions of 3 digits each.
	 * 
	 * @return String
	 * 
	 */
	private String reduceToPlaceValues() {
		StringBuilder sb = new StringBuilder(Constants.EMPTY);
		int counter = Constants.ZERO;
		long n = num;

		if(n==Constants.ZERO) {
			return Constants.WORD_ZERO;
		}
		while (n > Constants.ZERO) {

			int remainder = (int) (n % Constants.DIVISOR);// The remainder points the 3 digit values which constitute a
															// placeValue
			if (remainder > Constants.ZERO) {
				sb = new StringBuilder(readNumberAsWords(remainder, counter)).append(sb);
			}

			n /= Constants.DIVISOR;
			counter++; // The counter keeps tabs of the actual placeValues

		}

		return sb.toString().trim();
	}

	/**
	 * This method consumes a numeric of range (0-999) and a placeValue counter and
	 * returns the Word form of that number.
	 * 
	 * @param n
	 * @param counter
	 * @return
	 */
	private String readNumberAsWords(int n, int counter) {

		StringBuilder sb = new StringBuilder();
		int noOfDigits = String.valueOf(n).length();

		if (n > Constants.ZERO && n < Constants.TWENTY) {
			// Read the word directly for numbers[0-19]

			sb.append(Constants.primitiveNumbers[n]).append(Constants.SPACE);

		} else if (n % Constants.HUNDRED == Constants.ZERO && noOfDigits == Constants.THREE) {

			// Read the word directly for century numbers[100, 200, 300,...900], this can be
			// handled even by the last else loop, but doing it here for faster result
			sb.append(Constants.primitiveNumbers[n / Constants.HUNDRED]).append(Constants.SPACE)
					.append(Constants.placeValues[Constants.ZERO]).append(Constants.SPACE);

		} else if (n % Constants.TEN == Constants.ZERO && noOfDigits == Constants.TWO) {

			// Read the word directly for blind numbers[10, 20, 30,...90]
			sb.append(Constants.multipliersOfTen[n / Constants.TEN]).append(Constants.SPACE);

		} else if (noOfDigits == Constants.TWO) {
			/*
			 * If the number is a 2 digit non-blind number, it can be represented as the
			 * addition of a blind number and a single-digit number. eg., 34 = 30 +4; The
			 * words are put together for each operand.
			 */
			sb.append(Constants.multipliersOfTen[n / Constants.TEN]).append(Constants.SPACE)
					.append(Constants.primitiveNumbers[n % Constants.TEN]).append(Constants.SPACE);
		} else {
			/*
			 * If the number is a 3 digit number[0-999] it can be represented as the sum of
			 * a multipleOfHundred + a bind-number + a single-digit number. eg., 157 = 100 +
			 * 50 +7. The words are put together for each operand.
			 */
			sb.append(Constants.primitiveNumbers[n / Constants.HUNDRED]).append(Constants.SPACE)
					.append(Constants.placeValues[Constants.ZERO]).append(Constants.SPACE);

			String s = readNumberAsWords(n % Constants.HUNDRED, Constants.ZERO);

			if (s != null && s.trim().length() > Constants.ZERO) {
				sb.append(Constants.AND).append(Constants.SPACE).append(s);
			}
		}

		if (counter > Constants.ZERO) {
			sb.append(Constants.placeValues[counter]).append(Constants.SPACE);
		}

		return sb.toString();

	}

}
