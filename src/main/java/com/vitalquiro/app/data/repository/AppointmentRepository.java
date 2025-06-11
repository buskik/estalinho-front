package com.vitalquiro.app.data.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

import com.vitalquiro.app.data.model.Appointment;

import reactor.core.publisher.Mono;

public class AppointmentRepository {

        private final WebClient webClient;
        private String baseUrl;

        public AppointmentRepository(WebClient.Builder webClientBuilder,
                        @Value("${backend.api.url}") String apiUrl) {
                this.baseUrl = String.format("%s/appointment/", apiUrl);
                this.webClient = webClientBuilder.build(); // No base URL
        }

        public Mono<List<Appointment>> fetchAll() {
                return webClient.get()
                                .uri(baseUrl)
                                .retrieve()
                                .bodyToFlux(Appointment.class)
                                .collectList();
        };

        public Mono<Appointment> create(Appointment data) {
                return webClient.post()
                                .uri(baseUrl)
                                .bodyValue(data)
                                .retrieve()
                                .bodyToMono(Appointment.class);
        };

        public void delete(int id) {
                webClient.delete()
                                .uri(baseUrl + id)
                                .retrieve();

        };

        public Mono<Appointment> update(int id, Appointment data) {
                return webClient.put()
                                .uri(baseUrl)
                                .bodyValue(data)
                                .retrieve()
                                .bodyToMono(Appointment.class);
        };
}
