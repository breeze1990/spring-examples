package com.example.spring.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class AppProperties {
    @Getter
    @Value("${app.name}")
    private String appName;
}
