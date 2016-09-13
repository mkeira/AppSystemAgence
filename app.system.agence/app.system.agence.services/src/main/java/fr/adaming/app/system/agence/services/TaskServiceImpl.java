package fr.adaming.app.system.agence.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.app.system.agence.dao.TaskDao;
import fr.adaming.app.system.agence.model.Task;

@Component
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;

	public TaskDao getTaskDao() {
		return taskDao;
	}

	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	@Override
	@Transactional
	public void save(Task task) {
		taskDao.save(task);
		
	}

	@Override
	public List<Task> list() {
		return taskDao.list();
	}
	
}
