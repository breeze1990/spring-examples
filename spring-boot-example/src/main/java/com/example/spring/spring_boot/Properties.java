package com.example.spring.spring_boot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "props")
@Data
public class Properties {
    private String name;
    private String version;
    private String secret;
    private String env;
}
