package com.vitalquiro.app.data.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

import com.vitalquiro.app.data.dto.UserDto;
import com.vitalquiro.app.data.model.User;

import reactor.core.publisher.Mono;

public class UserRepository {

    private final WebClient webClient;
    private String baseUrl;

    public UserRepository(WebClient.Builder webClientBuilder,
            @Value("${backend.api.url}") String apiUrl) {
        this.baseUrl = String.format("%s/user/", apiUrl);
        this.webClient = webClientBuilder.build(); // No base URL
    }

    public Mono<List<User>> fetchAll() {
        return webClient.get()
                .uri(baseUrl)
                .retrieve()
                .bodyToFlux(User.class)
                .collectList();
    };

    public Mono<User> create(UserDto data) {
        return webClient.post()
                .uri(baseUrl)
                .bodyValue(data)
                .retrieve()
                .bodyToMono(User.class);
    };

    public void delete(int id) {
        webClient.delete()
                .uri(baseUrl + id)
                .retrieve();

    };

    public Mono<User> update(int id, User data) {
        return webClient.put()
                .uri(baseUrl)
                .bodyValue(data)
                .retrieve()
                .bodyToMono(User.class);
    };
}
