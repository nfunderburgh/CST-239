package Test;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestAssertion.class);
		
		for (Failure failure : result.getFailures()) {
			System.out.println(" A Junit test failed: " + failure.toString());
		}
		System.out.println("the JUnit Tests " + (result.wasSuccessful() ? "Passed" : "Failed"));
	}
}
