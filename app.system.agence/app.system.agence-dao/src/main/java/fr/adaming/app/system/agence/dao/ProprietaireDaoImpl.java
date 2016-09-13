package fr.adaming.app.system.agence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.app.system.agence.model.Proprietaire;


@Repository
public class ProprietaireDaoImpl implements ProprietaireDao  {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/* (non-Javadoc)
	 * @see fr.adaming.app.system.agence.dao.ProprietaireDao#getProprietaireByName(java.lang.String)
	 */
	@Override
	public Proprietaire getProprietaireByName(String name) {
		Proprietaire p = null;
		TypedQuery<Proprietaire>  query = entityManager.createNamedQuery("Proprietaire.findAll", Proprietaire.class);
		List<Proprietaire> result = query.getResultList();
		for (Proprietaire proprietaire : result) {
			if( name.equals(proprietaire.getNom())){
				p = proprietaire;
			}
		}
		return p;
	}

	/* (non-Javadoc)
	 * @see fr.adaming.app.system.agence.dao.ProprietaireDao#save(fr.adaming.app.system.agence.model.Proprietaire)
	 */
	@Override
	@Transactional
	public void save(Proprietaire proprietaire) {
		entityManager.persist(proprietaire);
	}

	/* (non-Javadoc)
	 * @see fr.adaming.app.system.agence.dao.ProprietaireDao#getProprietaireList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Proprietaire> getProprietaireList() {
		return entityManager.createQuery("select p from Proprietaire p ").getResultList();
	}

}
