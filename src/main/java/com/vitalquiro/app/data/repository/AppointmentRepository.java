package com.vitalquiro.app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vitalquiro.app.data.model.Appointment;

public interface AppointmentRepository
        extends
        JpaRepository<Appointment, Long>,
        JpaSpecificationExecutor<Appointment> {

}
