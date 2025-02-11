package com.flink.test.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/test")
public class TestController {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String test() {
        return "Have a nice day!";
    }
}
