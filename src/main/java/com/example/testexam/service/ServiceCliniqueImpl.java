package com.example.testexam.service;

import com.example.testexam.entity.Clinique;
import com.example.testexam.entity.Medecin;
import com.example.testexam.repository.CliniqueRepository;
import com.example.testexam.repository.MedecinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class ServiceCliniqueImpl implements IServiceClinique{
    private CliniqueRepository cliniqueRepository;
    private MedecinRepository medecinRepository;
    @Override
    public long ajouterClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique).getId();
    }

    @Override
    public void affecterMedecinActionnaireAClinique(int medecinId, int cliniqueId) {
        Medecin m = medecinRepository.findById((long) medecinId).get();
        Clinique c = cliniqueRepository.findById((long) cliniqueId).get();
        c.setMedecinGerant(m);
        cliniqueRepository.save(c);
    }

    @Override
    public void affecterMedecinOrdinaireAClinique(int medecinId, int cliniqueId) {
        Medecin m = medecinRepository.findById((long) medecinId).get();
        Clinique c = cliniqueRepository.findById((long) cliniqueId).get();
        Set<Medecin> aux = c.getMedecins();
        aux.add(m);
        c.setMedecins(aux);
        cliniqueRepository.save(c);
    }
}
