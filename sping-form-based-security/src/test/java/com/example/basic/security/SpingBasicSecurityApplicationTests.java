package com.example.basic.security;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootTest
class SpingBasicSecurityApplicationTests {

	@Test
	void testPasswordEncoders() {
		System.out.println("1 :"+new BCryptPasswordEncoder().encode("password"));
		SecureRandom random = new SecureRandom();
		  byte bytes[] = new byte[20];
		  random.nextBytes(bytes);
		  
		System.out.println("2 : "+new BCryptPasswordEncoder(12, random).encode("password"));
		System.out.println("3 : "+new Pbkdf2PasswordEncoder().encode("password"));
		System.out.println("4 : "+new Pbkdf2PasswordEncoder("secret", 10000, 128).encode("password"));
		System.out.println("5 :"+new SCryptPasswordEncoder().encode("password"));
		
		Map<String, PasswordEncoder> encoders =new HashMap<>();
		encoders.put("bcrypt", new BCryptPasswordEncoder());
		encoders.put("scrypt", new SCryptPasswordEncoder());
		
		System.out.println("6 :"+new DelegatingPasswordEncoder("bcrypt", encoders).encode("password"));

	}

}
