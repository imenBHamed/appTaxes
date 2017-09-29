package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.app.dao.EntrepriseRepository;
import com.app.dao.TaxesRepository;
import com.app.entities.Entreprise;
import com.app.entities.IR;
import com.app.entities.TVA;

@SpringBootApplication
@EntityScan("com.app.entities")
@EnableJpaRepositories("com.app.dao")
public class AppTaxesApplication implements CommandLineRunner {

	@Autowired
	private EntrepriseRepository entrepriseRepository;

	@Autowired
	private TaxesRepository taxesRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppTaxesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Entreprise e1= entrepriseRepository.save(new Entreprise("R1","r1@gmail.com","SARL"));

		Entreprise e2= entrepriseRepository.save(new Entreprise("R2","r2@gmail.com","SARL"));
		
		taxesRepository.save( new TVA("TVA HT", new Date(),500,e1));
		taxesRepository.save( new TVA("TVA VT", new Date(),5000,e1));
		taxesRepository.save( new IR("IR HT", new Date(),5000,e1));
		taxesRepository.save( new TVA("TVA HT", new Date(),800,e2));

	}
}
