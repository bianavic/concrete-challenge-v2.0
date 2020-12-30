package com.registration.challenge;

import com.registration.challenge.models.User;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class SystemTests {

    @Test
    public void testCreateReadDelete() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/user";

        User user = new User("Gonzales", "g@g.com");
        ResponseEntity<User> userResponseEntity = restTemplate.postForEntity(url, user, User.class);

        User[] users = restTemplate.getForObject(url, User[].class);
        Assertions.assertThat(users).extracting(User::getName).containsOnly("Gonzales");

        restTemplate.delete(url + "/" + userResponseEntity.getBody().getId());
        Assertions.assertThat(restTemplate.getForObject(url, User[].class)).isEmpty();
    }

    @Test
    public void testErrorHandlingReturnsBadRequest() {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/wrong";

        try {
            restTemplate.getForEntity(url, String.class);
        } catch (HttpClientErrorException e) {
            Assert.assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }
    }
}
