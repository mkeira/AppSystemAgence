package fr.adaming.app.system.agence.dao;

import java.util.List;

import fr.adaming.app.system.agence.model.Task;

public interface TaskDao {

	void save(Task task);

	List<Task> list();

}