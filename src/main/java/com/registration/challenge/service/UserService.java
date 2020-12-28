package com.registration.challenge.service;

import com.registration.challenge.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserService extends CrudRepository<User, Long> {

    Iterable<User> findByEmail(String email);

    @Override
    Optional<User> findById(Long aLong);
}
