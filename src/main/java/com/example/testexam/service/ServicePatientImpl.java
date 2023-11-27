package com.example.testexam.service;

import com.example.testexam.entity.Medecin;
import com.example.testexam.entity.Patient;
import com.example.testexam.repository.MedecinRepository;
import com.example.testexam.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ServicePatientImpl implements IServicePatient{
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;

    @Override
    @Transactional
    public long ajouterPatientEtAffecterAuMedecin(Patient patient, long idMedecin) {
        Medecin m = medecinRepository.findById(idMedecin).get();
        Set<Patient> patients = m.getPatients();
        Set<Medecin> medecins = new HashSet<>();

        patients.add(patient);
        medecins.add(m);

        m.setPatients(patients);
        patient.setMedecins(medecins);

        patientRepository.save(patient);
        medecinRepository.save(m);

        return patientRepository.save(patient).getId();
    }
}
