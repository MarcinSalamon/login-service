package com.example.login;

import org.junit.runner.notification.Failure;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.example.login.services.LoginServiceTest;

import org.junit.runner.Result;

@RunWith(Suite.class)
@SuiteClasses({LoginControllerTest.class, LoginServiceTest.class})
public class AllTests {
	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(AllTests.class);

	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());
	   }
}
