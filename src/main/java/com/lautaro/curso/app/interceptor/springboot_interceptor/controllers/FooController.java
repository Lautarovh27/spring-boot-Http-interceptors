package com.lautaro.curso.app.interceptor.springboot_interceptor.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/app")
public class FooController {

    @GetMapping("/foo")
    public Map<String, String> foo(){
        return Collections.singletonMap("message", "Handler foo del controller ");
    }
    
     @GetMapping("/bar")
    public Map<String, String> bar(){
        return Collections.singletonMap("message", "Handler bar del controller ");
    }

     @GetMapping("/baz")
    public Map<String, String> baz(){
        return Collections.singletonMap("message", "Handler baz del controller ");
    }
}
