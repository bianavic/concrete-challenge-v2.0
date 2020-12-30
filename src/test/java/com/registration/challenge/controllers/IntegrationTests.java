/**
package com.registration.challenge.controllers;

import com.registration.challenge.models.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ValidationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTests {
    
    @Autowired
    UserController userController;
    
    @Test
    public void testCreateReadDelete() {
        
        User user = new User("Gonzales", "g@g.com");
        
        User userResult = userController.create(user);
        
        Iterable<User> users = userController.read();
        Assertions.assertThat(users).first().hasFieldOrPropertyWithValue("name", "Gonzales");
        
        userController.delete(userResult.getId());
        Assertions.assertThat(userController.read()).isEmpty();
    }

    @Test(expected = ValidationException.class)
    public void errorHandlingValidationExceptionThrown() {
        userController.somethingIsWrong();
    }

}
