package com.inspire12.likelionbackend.module.core.properties.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(
    prefix = "server", // yml파일의 값을 가져올 때 그 위쪽의 path를 미리 지정해주는 것
    ignoreUnknownFields = true
)
@Getter
@Setter
public class ServerPortProperties {
    private String port;
}
