package com.registration.challenge;

import com.registration.challenge.controllers.UserController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.util.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ChallengeApplicationTests {

	@Autowired
	UserController userController;

	@Test
	void contextLoads() {
		assertNotNull(userController);
	}

}
