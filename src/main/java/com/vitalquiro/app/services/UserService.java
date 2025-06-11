package com.vitalquiro.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vitalquiro.app.data.dto.UserDto;
import com.vitalquiro.app.data.model.User;
import com.vitalquiro.app.data.repository.UserRepository;

import java.time.Duration;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> fetchAll() {
        return repository.fetchAll().block(TIMEOUT);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public void create(UserDto data) {
        repository.create(data).block(TIMEOUT);
    }

    public void update(int id, User data) {
        repository.update(id, data).block(TIMEOUT);
    }

}
