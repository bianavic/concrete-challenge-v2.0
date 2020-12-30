package com.registration.challenge.services;

import com.registration.challenge.models.User;
import com.registration.challenge.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServiceTests {

    @Autowired
    UserService userService;

    @Test
    public void testCreateReadDelete() {

        User user = new User("Gonzales", "g@g.com");

        userService.save(user);

        Iterable<User> users = userService.findAll();
        Assertions.assertThat(users).extracting(User::getName).containsOnly("Gonzales");

        userService.deleteAll();
        Assertions.assertThat(userService.findAll()).isEmpty();
    }

}
