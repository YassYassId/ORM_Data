package com.jpa.orm_data;

import com.jpa.orm_data.entities.Patient;
import com.jpa.orm_data.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class OrmDataApplication {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.set(2000, Calendar.DECEMBER, 1);
//        Date d1 = calendar1.getTime();
//
//        Calendar calendar2 = Calendar.getInstance();
//        calendar2.set(2000, Calendar.DECEMBER, 2);
//        Date d2 = calendar2.getTime();
//
//        Calendar calendar3 = Calendar.getInstance();
//        calendar3.set(2000, Calendar.DECEMBER, 3);
//        Date d3 = calendar3.getTime();
//        patientRepository.save(new Patient(null,"Jack", d1,false,85));
//        patientRepository.save(new Patient(null,"John",d2,true,60));
//        patientRepository.save(new Patient(null,"Jane",d3,false,99));
//
//        List<Patient> patients = patientRepository.findAll();
//        patients.forEach(System.out::println);
//
//        Patient patient = patientRepository.findById(Long.valueOf(2)).orElse(null);
//        System.out.println("***************");
//        System.out.println(patient.getId());
//        System.out.println(patient.getNom());
//        System.out.println(patient.getDateNaissance());
//        System.out.println(patient.isMalade());
//        System.out.println(patient.getScore());
//        System.out.println("***************");
//
//        List<Patient> sickPatients = patientRepository.findByMalade(true);
//        System.out.println("Patients malades: ");
//        sickPatients.forEach(p -> System.out.println(p));
//
//        Optional<Patient> patientSupp = patientRepository.findById(Long.valueOf(1));
//        if (patientSupp.isPresent()) {
//            patientRepository.delete(patientSupp.get());
//        } else {
//            System.out.println("Patient not found!");
//        }

    }
}

