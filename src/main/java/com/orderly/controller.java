package com.orderly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orderly.dto.Cols;
import com.orderly.dto.Project;
import com.orderly.dto.Task;
import com.orderly.service.IColumnService;
import com.orderly.service.IProjectService;
import com.orderly.service.ITaskService;

@Controller
public class controller {
	
	public controller() {
		
	}

	@Autowired
	private IProjectService projectService;
	
	@RequestMapping("/createBoard")
	public String createBoard(Project project) {
		project.setName("project1");
		try {
			projectService.save(project);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "board";
	}
	
	@Autowired
	private ITaskService taskService;
	
	@RequestMapping("/createTask")
	public String createTask(Task task) {
		task.setName("project1");
		task.setDescription("Demo Description");
		try {
			taskService.save(task);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "board";
	}
	
	@Autowired
	private IColumnService columnService;
	
	@RequestMapping("/createColumn")
	public String createColumn(Cols cols) {
		cols.setName("project1");
		try {
			columnService.save(cols);
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
		return "board";
	}
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/board")
	public String project() {
		return "board";
	}
	@RequestMapping("/searchResults")
	public String results() {
		return "searchResults";
	}
}
