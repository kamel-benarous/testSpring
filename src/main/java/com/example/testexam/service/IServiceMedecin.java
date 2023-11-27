package com.example.testexam.service;

import com.example.testexam.entity.Medecin;
import com.example.testexam.entity.Poste;

import java.util.List;

public interface IServiceMedecin {
    long ajouterMedecin(Medecin medecin);
    List<String> getCardiologueMedecinNames();

    long getNombrePatientsExaminesParMedecinPoste(Poste poste);
}
