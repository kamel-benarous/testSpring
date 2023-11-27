package com.example.testexam.service;

import com.example.testexam.entity.Patient;

public interface IServicePatient {
    long ajouterPatientEtAffecterAuMedecin(Patient patient, long idMedecin);
}
