# Hospital Management System

A Spring Boot application for managing hospital data including patients, doctors, appointments, and consultations.

## Table of Contents

- [Overview](#overview)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Entity Relationship Diagram](#entity-relationship-diagram)
- [Setup and Installation](#setup-and-installation)
- [Features](#features)
- [Database Configuration](#database-configuration)
- [API Documentation](#api-documentation)
- [Usage Examples](#usage-examples)
- [Extending the Application](#extending-the-application)

## Overview

This Hospital Management System provides a comprehensive solution for managing hospital operations. It allows creating and managing patients, doctors, appointments, and consultations through a well-structured relational database design.

## Technology Stack

- **Java 8+**
- **Spring Boot** - Framework for creating stand-alone, production-grade Spring-based applications
- **Spring Data JPA** - For data persistence using JPA
- **Hibernate** - ORM tool for database operations
- **MySQL** - Production database
- **H2 Database** - In-memory database for development/testing (configurable)
- **Lombok** - For reducing boilerplate code
- **Jackson** - For JSON processing

## Project Structure

The project follows a standard Spring Boot structure with the following key components:

### Entities

- **Patient** - Stores patient information (name, birth date, health status, etc.)
- **Medecin** - Represents doctors with specialization and contact details
- **RendezVous** - Manages appointments between patients and doctors
- **Consultation** - Records of consultations linked to appointments
- **StatusRDV** - Enum representing appointment status (PENDING, CANCELLED, DONE)

### Repositories

JPA repositories for database operations:

- `PatientRepository`
- `MedecinRepository`
- `RendezVousRepository`
- `ConsultationRepository`

### Services

Business logic layer:

- `IHospitalService` - Service interface
- `HospitalServiceImpl` - Implementation of service methods

## Entity Relationship Diagram
![image](https://github.com/user-attachments/assets/a4afdec5-8c0b-424d-8b26-da1f7885f09c)


## Setup and Installation

### Prerequisites

- Java 8 or higher
- Maven
- MySQL (for production)

### Running the Application

1. Clone the repository
2. Configure the database connection in `application.properties`
3. Build the project:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```

## Features

- Patient management (add, retrieve, update, delete)
- Doctor management with specialization
- Appointment scheduling and status tracking
- Consultation recording linked to appointments
- Flexible querying options using Spring Data JPA

## Database Configuration

The application supports both H2 in-memory database and MySQL. The configuration is in `application.properties`:

### For H2 Database (Development/Testing)

```properties
spring.datasource.url=jdbc:h2:mem:hopital-db
spring.h2.console.enabled=true
```

### For MySQL (Production)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hopital_db?createDatabaseIfNotExist=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=false
```

## API Documentation

The service layer (`IHospitalService`) provides the following core methods:

- `savePatient(Patient patient)` - Create or update a patient
- `saveMedecin(Medecin medecin)` - Create or update a doctor
- `saveRDV(RendezVous rendezVous)` - Schedule an appointment
- `saveConsultation(Consultation consultation)` - Record a consultation
- `findMedecinByNom(String nom)` - Find a doctor by name
- `findRDVById(Long id)` - Find an appointment by ID

## Usage Examples

The application includes a `CommandLineRunner` in the main class that demonstrates how to use the system:

```java
@Bean
CommandLineRunner start(IHospitalService service) {
    return args -> {
        // Creating patients
        Stream.of("Mohammed","Saad", "Walid")
                .forEach(name -> {
                    Patient patient = new Patient();
                    patient.setNom(name);
                    patient.setDateNaissance(new Date());
                    patient.setMalade(false);
                    patient.setScore(88);
                    service.savePatient(patient);
                });

        // Creating doctors
        Stream.of("Yassine","Amal", "Soufiane")
                .forEach(name -> {
                    Medecin medecin = new Medecin();
                    medecin.setNom(name);
                    medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                    medecin.setEmail(name + "@gmail.com");
                    service.saveMedecin(medecin);
                });

        // Creating appointments and consultations
        Patient patient = patientRepository.findById(1L).orElse(null);
        Medecin medecin = service.findMedecinByNom("Yassine");

        RendezVous rendezVous = new RendezVous();
        rendezVous.setDate(new Date());
        rendezVous.setStatus(StatusRDV.PENDING);
        rendezVous.setMedecin(medecin);
        rendezVous.setPatient(patient);
        service.saveRDV(rendezVous);

        RendezVous rendezVous1 = service.findRDVById(1L).orElse(null);
        Consultation consultation = new Consultation();
        consultation.setDateConsultation(new Date());
        consultation.setRendezVous(rendezVous1);
        consultation.setRapport("Rapport de consultation");
        service.saveConsultation(consultation);
    };
}
```

## Extending the Application

To extend the application with new features:

1. Define new entities in the `entities` package
2. Create corresponding repositories in the `repositories` package
3. Add service methods to the `IHospitalService` interface
4. Implement the methods in `HospitalServiceImpl`
5. Update database configuration if needed
