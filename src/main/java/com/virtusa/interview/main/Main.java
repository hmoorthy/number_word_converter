package com.virtusa.interview.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.virtusa.interview.common.Constants;
import com.virtusa.interview.utility.NumberToWordConverter;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String result = null;
		try {
			// read a long value directly from stdin, then no need to worry about leading
			// zeroes
			long input = sc.nextLong();

			// convert to words
			result = new NumberToWordConverter(input).convertToWord();

			System.out.println(result);

			// print the exception messages on screen
		} catch (InputMismatchException ime) {
			System.out.println(Constants.INPUT_MISMATCH);

		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());

		} catch (Exception e) {
			System.out.println(e.getMessage());
//			e.printStackTrace(); use ExceptionUtils library to get StackTrace if needed,as some exceptions carry no message

		} finally {
			sc.close();
		}

	}

}
