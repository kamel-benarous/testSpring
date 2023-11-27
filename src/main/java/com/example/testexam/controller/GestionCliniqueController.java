package com.example.testexam.controller;

import com.example.testexam.entity.Clinique;
import com.example.testexam.entity.Medecin;
import com.example.testexam.entity.Patient;
import com.example.testexam.entity.Poste;
import com.example.testexam.service.IServiceClinique;
import com.example.testexam.service.IServiceMedecin;
import com.example.testexam.service.IServicePatient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("")
public class GestionCliniqueController {
    IServiceClinique serviceClinique;
    IServiceMedecin serviceMedecin;
    IServicePatient servicePatient;

    @PostMapping("ajouterClinique")
    long ajouterCinique(@RequestBody Clinique clinique) {
        return serviceClinique.ajouterClinique(clinique);
    }

    @PostMapping("ajoutermedecin")
    long ajouterMedecin(@RequestBody Medecin medecin) {
        return serviceMedecin.ajouterMedecin(medecin);
    }

    @PutMapping("affectermedecingererclinique/{medecinId}/{cliniqueId}")
    public void affecterMedecinActionnaireAClinique(@PathVariable int medecinId, @PathVariable int cliniqueId) {
        serviceClinique.affecterMedecinActionnaireAClinique(medecinId, cliniqueId);
    }

    @PutMapping("affectermedecinordinaireclinique/{medecinId}/{cliniqueId}")
    public void affecterMedecinOrdinaireAClinique(@PathVariable int medecinId, @PathVariable int cliniqueId) {
        serviceClinique.affecterMedecinOrdinaireAClinique(medecinId, cliniqueId);
    }

    @PutMapping("ajouterpatientaffectermedecin/{idMedecin}")
    public long ajouterPatientEtAffecterAuMedecin(@RequestBody Patient patient, @PathVariable long idMedecin) {
        return servicePatient.ajouterPatientEtAffecterAuMedecin(patient, idMedecin);
    }

    @GetMapping("cardiologuemedecinnames")
    public List<String> getCardiologueMedecinNames() {
        return serviceMedecin.getCardiologueMedecinNames();
    }

    @GetMapping("NombrePatientsExaminesParMedecinPoste")
    public long getNombrePatientsExaminesParMedecinPoste(@RequestParam Poste poste) {
        return serviceMedecin.getNombrePatientsExaminesParMedecinPoste(poste);
    }

}
