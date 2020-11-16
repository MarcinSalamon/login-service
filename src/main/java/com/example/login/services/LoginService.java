package com.example.login.services;

import java.util.regex.Pattern;

import com.example.login.exceptions.LoginException;
import org.springframework.stereotype.Service;

import com.example.login.beans.LoginInfo;


@Service
public class LoginService {
	
	public LoginInfo validateUser(LoginInfo info) {
		if(checkIfContainsUppercase(info.getPassword())) {
			throw new LoginException("Password must contain only lowercase characters.", new Throwable());
		}
		if(!checkIfHasNumbers(info.getPassword())) {
			throw new LoginException("Password must contain a number.", new Throwable());
		}
		if(!checkLength(info.getPassword())) {
			throw new LoginException("Password must be between 5 and 12 characters long.", new Throwable());
		}
		if(checkForSpecialCharacters(info.getPassword())) {
			throw new LoginException("Password must not contain special characters.", new Throwable());
		}
		if(checkForSequences(info.getPassword())) {
			throw new LoginException("Password must not contain repeating sequences.", new Throwable());
		}
		
		return info;
	}
	
	public boolean checkIfContainsUppercase(String password) {
		String regex = ".*[A-Z].*";
		return password.matches(regex);
	}
	
	public boolean checkIfHasNumbers(String password) {
		String regex = ".*\\d.*";
		return password.matches(regex);
	}
	
	public boolean checkLength(String password) {
		if(password.length() >= 5 && password.length() <= 12) {
			return true;
		}
		return false;
	}
	
	public boolean checkForSpecialCharacters(String password) {
		String regex = "[^\\w\\s]";
		Pattern p = Pattern.compile(regex);
		return p.matcher(password).find();
	}
	
	public boolean checkForSequences(String password) {
		String regex = "(...+)\\1";
		Pattern p = Pattern.compile(regex);
		return p.matcher(password).find();
	}
	
}
