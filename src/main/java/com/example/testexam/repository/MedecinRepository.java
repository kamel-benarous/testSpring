package com.example.testexam.repository;

import com.example.testexam.entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository
        extends JpaRepository<Medecin, Long> {
}
