package com.example.testexam.repository;

import com.example.testexam.entity.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CliniqueRepository
        extends JpaRepository<Clinique, Long> {
}
