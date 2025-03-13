package com.jpa.orm_data.repositories;

import com.jpa.orm_data.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
