package com.example.spring.controller;

import com.example.spring.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    private final AppProperties appProperties;

    @Autowired
    public AppController(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @GetMapping("/app")
    public String getApp() {
        return appProperties.getAppName();
    }
}
