package com.duggavamshidhar.sharingan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App {

    @GetMapping("/")
    public String index() {
        return "Hello, World!";
    }

}
