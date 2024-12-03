package com.example.restarea.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
@RequiredArgsConstructor
@Log4j2
public class HomeCountroller {

    @GetMapping("/home")
    public String home(){
        return null;
    }
}
