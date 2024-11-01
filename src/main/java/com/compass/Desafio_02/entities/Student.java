package com.compass.Desafio_02.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends Person implements Serializable {

    @Column(nullable = false)
    private String address;

    @OneToOne
    private Course course;

    @OneToOne
    private Registration registration;
}
