package com.registration.challenge;

import com.registration.challenge.models.User;
import org.assertj.core.api.Assertions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SystemTests {

    public void testCreateReadDelete() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/user";

        User user = new User("Joao", "Maria");
        ResponseEntity<User> entity = restTemplate.postForEntity(url, user, User.class);

        User[] users = restTemplate.getForObject(url, User[].class);
        Assertions.assertThat(users).extracting(User::getName).containsOnly("m@m.com");

        restTemplate.delete(url, "/" + entity.getBody().getId());
        Assertions.assertThat(restTemplate.getForObject(url, User[].class)).isEmpty();
    }
}
