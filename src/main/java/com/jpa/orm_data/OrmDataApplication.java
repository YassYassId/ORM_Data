package com.jpa.orm_data;

import com.jpa.orm_data.entities.Patient;
import com.jpa.orm_data.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class OrmDataApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(Patient.builder()
                        .nom("Jack")
                        .dateNaissance(new Date(2000, 1, 1))
                        .malade(true)
                        .score(85)
                .build());
        patientRepository.save(Patient.builder()
                .nom("John")
                .dateNaissance(new Date(2000, 1, 2))
                .malade(false)
                .score(60)
                .build());
        patientRepository.save(Patient.builder()
                .nom("Jane")
                .dateNaissance(new Date(2000, 1, 3))
                .malade(true)
                .score(90)
                .build());

        
    }
}
