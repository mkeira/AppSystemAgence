package fr.adaming.app.system.agence.web.beans;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.adaming.app.system.agence.model.Proprietaire;
import fr.adaming.app.system.agence.services.ProprietaireService;

@Component("proprio")
@Scope("request")
public class ProprietaireBean {

	private static final Logger logger = LoggerFactory.getLogger(ProprietaireBean.class);
	
	private Proprietaire proprietaire = new Proprietaire();
	private List<Proprietaire> proprietaires;
	
	@Autowired
	private ProprietaireService proprietaireService;

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public List<Proprietaire> getProprietaires() {
		if(proprietaires == null){
			proprietaires = proprietaireService.getProprietaireList();
		}
		logger.debug("Proprio "+ proprietaires.get(0).getNom());
		return proprietaires;
	}

	public void saveP(){
		proprietaireService.save(proprietaire);
		proprietaire = new Proprietaire();
		proprietaires =null;
	}
	public void setProprietaires(List<Proprietaire> proprietaires) {
		this.proprietaires = proprietaires;
	}

	
	

}
