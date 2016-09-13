package app.system.agence.services.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.app.system.agence.model.BienImmo;
import fr.adaming.app.system.agence.model.Proprietaire;
import fr.adaming.app.system.agence.services.ProprietaireService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/appplication-context-services-test.xml")
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ProprietaireServiceTest {
	
	@Autowired
	private ProprietaireService service;
	

	@Test
	public void testListProprietaireDao() {
		Proprietaire proprietaire = new Proprietaire();
		proprietaire.setNom("Tata");
		BienImmo bienImmo1 = new BienImmo();
		bienImmo1.setTypeBien("Maison");
		proprietaire.setBienImmo1(bienImmo1 );
		Proprietaire proprio = service.save(proprietaire);
		System.out.println(proprietaire.getId());
		Assert.assertNotNull("Not null",proprio.getBienImmo1().getId() );
	}


}
