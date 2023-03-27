package com.example.SpringAngular.repository;

import com.example.SpringAngular.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
