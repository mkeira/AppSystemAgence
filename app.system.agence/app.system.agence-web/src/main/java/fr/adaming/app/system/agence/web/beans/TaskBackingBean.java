package fr.adaming.app.system.agence.web.beans;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.adaming.app.system.agence.model.Task;
import fr.adaming.app.system.agence.services.TaskService;

@Component("taskBB")
@Scope("request")
public class TaskBackingBean {

	private static final Logger logger = LoggerFactory.getLogger(TaskBackingBean.class);

	private Task task = new Task();
	private List<Task> tasks;

	@Autowired
	private TaskService taskService;

	
	public String getMessage() {
		logger.debug("Returning message from task home bean");
		return "Hello from Spring";
	}	

	public Task getTask() {
		return task;
	}

	public void saveTask() {
		taskService.save(task);
		task = new Task();
		invalidateTasks();
	}

	private void invalidateTasks() {
		tasks = null;
	}

	public List<Task> getTasks() {
		if (tasks == null) {
			tasks = taskService.list();
		}
		return tasks;
		
	}
}
