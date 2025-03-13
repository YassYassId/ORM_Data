package com.jpa.orm_data.repositories;

import com.jpa.orm_data.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByMalade(boolean b);
    Patient findPatientByNom(String nom);

}
