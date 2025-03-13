package com.jpa.orm_data;

import com.jpa.orm_data.entities.*;
import com.jpa.orm_data.repositories.ConsultatonRepository;
import com.jpa.orm_data.repositories.MedecinRepository;
import com.jpa.orm_data.repositories.PatientRepository;
import com.jpa.orm_data.repositories.RendezVousRepository;
import com.jpa.orm_data.services.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class OrmDataApplication {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmDataApplication.class, args);
    }


    @Bean
    CommandLineRunner start(IHospitalService service) {
        return args -> {
            Stream.of("Mohammed","Saad", "Walid")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        patient.setScore(88);
                        service.savePatient(patient);
                    });
            Stream.of("Yassine","Amal", "Soufiane")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        medecin.setEmail(name + "@gmail.com");
                        service.saveMedecin(medecin);
                    });

            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findPatientByNom("Mohammed");

            Medecin medecin = service.findMedecinByNom("Yassine");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            service.saveRDV(rendezVous);


            RendezVous rendezVous1 = service.findRDVById(1l).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de consultation");
            service.saveConsultation(consultation);
        };
    }

//    @Override
//    public void run(String... args) throws Exception {
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

//    }
}

