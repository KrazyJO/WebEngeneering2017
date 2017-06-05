package com.micromata.webengineering.demo.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.micromata.webengineering.demo.user.User;

@RestController
@RequestMapping("/user")
public class AuthenticationController {

	@Autowired
	private AuthenticationService service;
	
	public static class UserLogin {
		public String email;
		public String password;
		
		@Override
		public String toString() 
		{
			return "UserLogin {"
					+ "email='" + email + "'"  + 
					", password='" + password + "'" +
					"}";
		}
	}
	
//	public static class UserToken {
//		public User user;
//		public String token;
//	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<AuthenticationService.UserToken> login(@RequestBody UserLogin userLogin) {
        AuthenticationService.UserToken token = service.login(userLogin.email, userLogin.password);

        if (token == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(token, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public UserToken login(@RequestBody UserLogin userLogin)
//	{
////		return "<JWT-Token>: " + userLogin;
//		UserToken userToken = new UserToken();
//		userToken.user = new User();
//		userToken.user.setEmail(userLogin.email);
//		userToken.user.setId(1L);
//		
//		String secret = "Severus Snape was a good guy!";
//		String token = Jwts.builder().setSubject(userToken.user.getEmail()).signWith(SignatureAlgorithm.HS512, secret).compact();
//		
//		userToken.token = token;
//		
//		return userToken;
//	}
	
	
	//TODO weiter im AuthenticationController
}
