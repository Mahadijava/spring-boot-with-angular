package com.example.SpringAngular.service;

import com.example.SpringAngular.model.Appointment;
import com.example.SpringAngular.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // this is a must
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment>appointmentList(){
        return appointmentRepository.findAll();
    }

    public void save(Appointment appointment){
        appointmentRepository.save(appointment);
    }


    public void update(Long id, Appointment appointment){
        appointmentRepository.findById(id)
                .map(old -> {
                    old.setPname(appointment.getPname());
                    old.setGender(appointment.getGender());
                    old.setPphone(appointment.getPphone());
                    old.setDepartment(appointment.getDepartment());
                    old.setDoctorName(appointment.getDoctorName());
                    old.setAppointdate(appointment.getAppointdate());
                    return appointmentRepository.save(old);
                })
                .orElseGet(() -> {
                    return appointmentRepository.save(appointment);
                });
    }


    public Appointment getbyId(Long id){
        return appointmentRepository.findById(id).orElse(new Appointment());  // orElse must as it returns optional
    }
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }
}
