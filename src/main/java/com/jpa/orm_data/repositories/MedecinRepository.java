package com.jpa.orm_data.repositories;

import com.jpa.orm_data.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
