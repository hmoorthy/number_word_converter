package com.virtusa.interview.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	// To be able to run from this test class from command line
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(NumberToWordConverterFailureTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
	}
}
