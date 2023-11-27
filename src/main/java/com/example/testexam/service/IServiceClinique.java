package com.example.testexam.service;

import com.example.testexam.entity.Clinique;

public interface IServiceClinique {
    long ajouterClinique(Clinique clinique);
    void affecterMedecinActionnaireAClinique(int medecinId, int cliniqueId);
    void affecterMedecinOrdinaireAClinique(int medecinId, int cliniqueId);
}
