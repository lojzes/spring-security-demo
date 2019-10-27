package com.lojzes.oauth.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("test")
    public String test() {
        return "hello";
    }

    @GetMapping("oauth/test")
    public String oauth(@RequestParam("code") String code) {
        System.err.println(code);
        return code;
    }

}
