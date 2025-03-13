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

---

## Overview

This Hospital Management System provides a comprehensive solution for managing hospital operations. It allows creating and managing patients, doctors, appointments, and consultations through a well-structured relational database design.

---

## Technology Stack

- **Java 8+**
- **Spring Boot** - Framework for creating stand-alone, production-grade Spring-based applications
- **Spring Data JPA** - For data persistence using JPA
- **Hibernate** - ORM tool for database operations
- **MySQL** - Production database
- **H2 Database** - In-memory database for development/testing (configurable)
- **Lombok** - For reducing boilerplate code
- **Jackson** - For JSON processing

---

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

---

## Entity Relationship Diagram

![image](https://github.com/user-attachments/assets/712030bb-1603-4deb-91a3-eae6e985adea)
