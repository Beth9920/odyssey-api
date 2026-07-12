package com.elisabet.odyssey_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api")
    public String api() {
        return "Odyssey API is running";
    }
}
