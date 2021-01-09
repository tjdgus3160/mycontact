package com.fastcampus.javaallinone.project3.mycontact.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloWorldController {

    @GetMapping(value = "/api/helloWorld")
    public String helloWorld(){
        return "HelloWorld";
    }

    @GetMapping("/api/helloException")
    public String helloException(){
        throw new RuntimeException("Hello RuntimeException");
    }
}
