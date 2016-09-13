package fr.adaming.app.system.agence.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.app.system.agence.dao.ProprietaireDao;
import fr.adaming.app.system.agence.model.Proprietaire;

@Service
@Transactional
public class ProprietaireServiceImpl implements ProprietaireService {

	@Autowired
	private ProprietaireDao proprietaireDao;
	
	public Proprietaire save(Proprietaire proprietaire) {
		proprietaireDao.save(proprietaire);
		return proprietaire;
	}

	public List<Proprietaire> getProprietaireList() {
		return proprietaireDao.getProprietaireList();
	}
}
