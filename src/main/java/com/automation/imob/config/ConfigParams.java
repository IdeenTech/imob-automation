package com.automation.imob.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ConfigParams {

    @Value("${config.params.host}")
    private String host;

    @Value("${config.params.host-auth}")
    private String hostAuth;

    @Value("${config.params.basic-token}")
    private String basicToken;
}
