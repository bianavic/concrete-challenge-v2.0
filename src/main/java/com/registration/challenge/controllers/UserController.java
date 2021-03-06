/**
 *

package com.registration.challenge.controllers;

import com.registration.challenge.models.User;
import com.registration.challenge.service.UserService;
import com.registration.challenge.util.ErrorMessage;
import com.registration.challenge.util.FieldErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User create(@Valid @RequestBody User user){
            return userService.save(user);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionhandler(MethodArgumentNotValidException e) {

        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream().map(fieldError -> new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());
        return fieldErrorMessages;
    }

    @GetMapping("/user")
    public Iterable<User> read() {
        return userService.findAll();
    }

    @PutMapping("/user")
    ResponseEntity<User> update(@RequestBody User user) {
        if (userService.findById(user.getId()).isPresent())
            return new ResponseEntity(userService.save(user), HttpStatus.OK);
        else
            return new ResponseEntity(user, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/user/{id}")
    Optional<User> findByEmail(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/user/email")
    Iterable<User> findByQuery(@RequestParam("email") String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/wrong")
    public User somethingIsWrong() {
        throw new ValidationException("Something is wrong");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    String exceptionHandler(ValidationException e) {
        return e.getMessage();
    }
}
 */