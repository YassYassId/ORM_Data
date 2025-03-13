package com.jpa.orm_data.repositories;

import com.jpa.orm_data.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultatonRepository extends JpaRepository<Consultation, Long> {
}
