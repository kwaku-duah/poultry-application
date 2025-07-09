package com.poultry.authservice.client;

import com.poultry.authservice.config.WebClientConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class UserServiceClient {
    private final WebClient webClient;

    private String userServiceBaseUrl;

    public UserServiceClient(WebClient webClient) {
        this.webClient = webClient;
    }
}
