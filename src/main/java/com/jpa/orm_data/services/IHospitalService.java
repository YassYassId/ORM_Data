package com.jpa.orm_data.services;

import com.jpa.orm_data.entities.Consultation;
import com.jpa.orm_data.entities.Medecin;
import com.jpa.orm_data.entities.Patient;
import com.jpa.orm_data.entities.RendezVous;

import java.util.Optional;

public interface IHospitalService {

    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

    Medecin findMedecinByNom(String yassine);

    Optional<RendezVous> findRDVById(Long l);
}
