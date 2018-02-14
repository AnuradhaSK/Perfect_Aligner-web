package com.anuradha.perfectaligner.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {


    @GetMapping("/test")
    public String getVal(String name) {
        return "pass" + name;
    }



}