package fr.adaming.app.system.agence.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.adaming.app.system.agence.model.Proprietaire;

public interface ProprietaireDao {

	Proprietaire getProprietaireByName(String name);

	void save(Proprietaire proprietaire);

	List<Proprietaire> getProprietaireList();

}