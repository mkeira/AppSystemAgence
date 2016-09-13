package fr.adaming.app.system.agence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.app.system.agence.model.Task;


@Component
public class TaskDaoImpl implements TaskDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see fr.adaming.app.system.agence.dao.TaskDao#save(fr.adaming.app.system.agence.model.Task)
	 */
	@Override
	public void save(Task task) {
		entityManager.persist(task);
	}

	/* (non-Javadoc)
	 * @see fr.adaming.app.system.agence.dao.TaskDao#list()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Task> list() {
		return entityManager.createQuery("select t from Task t")
				.getResultList();
	}

}
