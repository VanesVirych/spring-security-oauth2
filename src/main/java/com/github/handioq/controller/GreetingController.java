package com.github.handioq.controller;

import com.github.handioq.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(Principal principal) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, principal.getName()));
    }

}