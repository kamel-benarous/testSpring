package com.example.testexam.service;

import com.example.testexam.entity.Medecin;
import com.example.testexam.entity.Poste;
import com.example.testexam.entity.Specialite;
import com.example.testexam.repository.MedecinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ServiceMedecinImpl implements IServiceMedecin{
    private MedecinRepository medecinRepository;
    @Override
    public long ajouterMedecin(Medecin medecin) {
        return medecinRepository.save(medecin).getId();
    }

    @Override
    public List<String> getCardiologueMedecinNames() {
        return medecinRepository.findAll().stream()
                .filter(m -> m.getSpecialite() == Specialite.CARDIOLOGUE)
                .map(Medecin::getNom)
                .collect(Collectors.toList());
    }

    @Override
    public long getNombrePatientsExaminesParMedecinPoste(Poste poste) {
        return medecinRepository.findAll().stream()
                .filter(m -> Objects.equals(m.getPoste().toString(), poste.toString()))
                .findFirst()
                .get().getPatients().size();
    }
}
