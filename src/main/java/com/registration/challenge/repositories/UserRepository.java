package com.registration.challenge.repositories;

import com.registration.challenge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUserById(Long id);
}
