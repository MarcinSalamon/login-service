package com.example.login.services;

import static org.junit.Assert.*;
import com.example.login.services.LoginService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {

	@Autowired
	LoginService loginService;
	
	@Test
	public void checkIfContainsUppercaseNoUppercase() {
		String password = "password";
		assertFalse(loginService.checkIfContainsUppercase(password));
	}
	
	@Test
	public void checkIfContainsUppercaseWithUppercase() {
		String password = "Password1";
		assertTrue(loginService.checkIfContainsUppercase(password));
	}
	
	@Test
	public void checkIfHasNumbersNoNumbers() {
		String password = "password";
		assertFalse(loginService.checkIfHasNumbers(password));
	}
	
	@Test
	public void checkIfHasNumbersHasNumbers() {
		String password = "password1";
		assertTrue(loginService.checkIfHasNumbers(password));
	}
	
	@Test 
	public void checkLengthIsBetweenEdges() {
		String password = "password";
		assertTrue(loginService.checkLength(password));
	}
	
	@Test 
	public void checkLengthIsFive() {
		String password = "pass1";
		assertTrue(loginService.checkLength(password));
	}
	
	@Test 
	public void checkLengthIsTwelve() {
		String password = "passwordpass";
		assertTrue(loginService.checkLength(password));
	}
	
	@Test 
	public void checkLengthIsBelowFive() {
		String password = "pass";
		assertFalse(loginService.checkLength(password));
	}
	
	@Test 
	public void checkLengthIsAboveTwelve() {
		String password = "passwordpass1";
		assertFalse(loginService.checkLength(password));
	}
	
	@Test
	public void checkForSequencesOfTwoRepeated() {
		String password = "papapa";
		assertFalse(loginService.checkForSequences(password));
	}
	
	@Test
	public void checkForSequencesOfFourRepeated() {
		String password = "passpasspass";
		assertTrue(loginService.checkForSequences(password));
	}
	
	@Test
	public void checkForSpecialCharactersHasSpecial() {
		String password = "pass1!";
		assertTrue(loginService.checkForSpecialCharacters(password));
	}
	
	@Test
	public void checkForSpecialCharactersNoSpecial() {
		String password = "pass1";
		assertFalse(loginService.checkForSpecialCharacters(password));
	}
	
	@Test
	public void checkForSequencesOfThreeWithBreak() {
		String password = "pasbpas";
		assertFalse(loginService.checkForSequences(password));
	}
	
	@Test
	public void checkForSequencesNoSequences() {
		String password = "pasword";
		assertFalse(loginService.checkForSequences(password));
	}
}
