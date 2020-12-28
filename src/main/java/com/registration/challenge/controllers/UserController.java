package com.registration.challenge.controllers;

import com.registration.challenge.models.User;
import com.registration.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    User create(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/getUser")
    Iterable<User> read() {
        return userService.findAll();
    }

    @PutMapping("/updateUser")
    User update(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/getUser/{id}")
    void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/getUser/{id}")
    Optional<User> findByEmail(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/getUser/email")
    Iterable<User> findByQuery(@RequestParam("email") String email) {
        return userService.findByEmail(email);
    }

    /**
    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {

        return userRepository.getOne(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userRepository.saveAndFlush(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        return (userRepository.existsById(id))
                ? new ResponseEntity<User>(create(user), HttpStatus.CREATED)
                : new ResponseEntity<User>(user, HttpStatus.OK);
    }
    **/

}
