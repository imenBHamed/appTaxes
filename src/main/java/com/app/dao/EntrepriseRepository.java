package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

}
