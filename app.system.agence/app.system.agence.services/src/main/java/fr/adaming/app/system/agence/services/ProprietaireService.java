package fr.adaming.app.system.agence.services;

import java.util.List;

import fr.adaming.app.system.agence.model.Proprietaire;


public interface ProprietaireService {

	Proprietaire save(Proprietaire proprietaire);

	List<Proprietaire> getProprietaireList();
}