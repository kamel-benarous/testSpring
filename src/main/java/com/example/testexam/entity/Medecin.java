package com.example.testexam.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private Date dateEmbauche;
    private String email;
    private String pwd;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    @Enumerated(EnumType.STRING)
    private Poste poste;

    @OneToOne(mappedBy = "medecinGerant")
    private Clinique cliniqueGeree;

    @ManyToOne()
    private Clinique clinique;

    @ManyToMany
    private Set<Patient> patients;
}
