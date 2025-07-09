package com.poultry.authservice.client;

import com.poultry.authservice.dto.AuthResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class UserServiceClient {
    /* injecting spring managed bean Webclient
    * */
    private final WebClient webClient;

    @Value("${user-service.base-url}")
    private String userServiceBaseUrl;

    public UserServiceClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<AuthResponseDto> getUserByEmail(String email) {
        return webClient.get()
                .uri(userServiceBaseUrl + "/api/v1/users/email/{email}", email)
                .retrieve()
                .bodyToMono(AuthResponseDto.class);
    }
}
