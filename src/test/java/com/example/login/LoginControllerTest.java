package com.example.login;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.login.beans.LoginInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

	@MockBean
	private LoginInfo loginInfo;
	
	@Autowired
	private LoginController loginController;
	
	private Map<String, String> successResponse = Collections.singletonMap("message", "Login successful!");
	
	//tests for correct response
	@Test
	public void testLoginCorrect() throws Exception {
		LoginInfo mockLoginInfo = new LoginInfo("login", "password1");
		ResponseEntity<Object> responseEntity = loginController.login(mockLoginInfo);
		
		assertEquals(responseEntity.getStatusCodeValue(), 200);
		assertEquals(responseEntity.getBody(), successResponse);
	}
	
	//tests for failure, doesn't test every scenario as that is handled by the LoginService tests
	@Test
	public void testLoginPasswordHasCapital() throws Exception {
		LoginInfo mockLoginInfo = new LoginInfo("", "");
		ResponseEntity<Object> responseEntity = loginController.login(mockLoginInfo);
		
		assertEquals(responseEntity.getStatusCodeValue(), 400);
		assertNotEquals(responseEntity.getBody(), successResponse);
	}
}
