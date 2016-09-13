package fr.adaming.app.system.agence.services;

import java.util.List;

import fr.adaming.app.system.agence.model.Task;


public interface TaskService {
	
	public void save(Task task) ;
	
	public List<Task> list();

}