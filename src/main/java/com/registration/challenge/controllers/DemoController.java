package com.registration.challenge.controllers;

import com.registration.challenge.models.Demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/message")
    Demo send() {
            return new Demo("My first message");
    }

    @PostMapping("/message")
    Demo echo(@RequestBody Demo demo) {
        return demo;
    }
}
