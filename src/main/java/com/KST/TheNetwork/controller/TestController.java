package com.KST.TheNetwork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/private")
    public String privateRoute() {
        return "Private route";
    }
}
