package com.jpa.orm_data.services;

import com.jpa.orm_data.entities.Consultation;
import com.jpa.orm_data.entities.Medecin;
import com.jpa.orm_data.entities.Patient;
import com.jpa.orm_data.entities.RendezVous;
import com.jpa.orm_data.repositories.ConsultatonRepository;
import com.jpa.orm_data.repositories.MedecinRepository;
import com.jpa.orm_data.repositories.PatientRepository;
import com.jpa.orm_data.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultatonRepository consultatonRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultatonRepository consultatonRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultatonRepository = consultatonRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {

        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultatonRepository.save(consultation);
    }

    @Override
    public Medecin findMedecinByNom(String nom) {
        return medecinRepository.findMedecinByNom(nom);
    }

    @Override
    public Optional<RendezVous> findRDVById(Long l) {
        return rendezVousRepository.findById(l);
    }
}
