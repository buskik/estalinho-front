package com.vitalquiro.app.services;

import java.time.Duration;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vitalquiro.app.data.model.Appointment;
import com.vitalquiro.app.data.repository.AppointmentRepository;

@Service
public class AppointmentService {

    private final AppointmentRepository repository;
    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public List<Appointment> fetchAll() {
        return repository.fetchAll().block(TIMEOUT);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public void create(Appointment data) {
        repository.create(data).block(TIMEOUT);
    }

    public void update(int id, Appointment data) {
        repository.update(id, data).block(TIMEOUT);
    }

}
