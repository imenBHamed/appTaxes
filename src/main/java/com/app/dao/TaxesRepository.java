package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Entreprise;
import com.app.entities.Taxe;

public interface TaxesRepository extends JpaRepository<Taxe, Long> {
	public List<Taxe> findByEntreprise(Entreprise e);

}
