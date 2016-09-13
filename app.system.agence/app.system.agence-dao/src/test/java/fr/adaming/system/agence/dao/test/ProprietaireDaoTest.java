package fr.adaming.system.agence.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.app.system.agence.dao.ProprietaireDao;
import fr.adaming.app.system.agence.model.BienImmo;
import fr.adaming.app.system.agence.model.Proprietaire;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/db-dao-test.xml")
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class ProprietaireDaoTest {

	@Autowired
	private ProprietaireDao dao;
	
	@Test
	public void testListProprietaireDao() {
		List<Proprietaire> proprietaires = dao.getProprietaireList();
		Assert.assertNotNull("La liste de proprios ne doit pas etre vide",proprietaires );
	}
	@Test
	public void testCreateProprietaire(){
		
		Proprietaire proprietaire = new Proprietaire();
		proprietaire.setNom("Titi22");
		BienImmo bienImmo1 = new BienImmo();
		bienImmo1.setTypeBien("Appart22");
		proprietaire.setBienImmo1(bienImmo1 );
		dao.save(proprietaire);
		Assert.assertNotNull(proprietaire);
		System.out.println(proprietaire.getId() +" "+ proprietaire.getBienImmo1().getId());
	}
	
	@Test
	public void testProprioByNameKO(){
		Proprietaire p = dao.getProprietaireByName("FAUX");
		Assert.assertNull( p);
	}

}
