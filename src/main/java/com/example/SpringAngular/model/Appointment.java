package com.example.SpringAngular.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Appointment extends BaseModel {
    private String pname, pphone, gender, doctorName, department;
    private String appointdate;
}
