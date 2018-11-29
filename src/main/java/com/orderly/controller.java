package com.orderly;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orderly.dto.Cols;
import com.orderly.dto.Project;
import com.orderly.dto.Task;
import com.orderly.service.IColumnService;
import com.orderly.service.IProjectService;
import com.orderly.service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class controller {
	
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IProjectService projectService;
	
	@RequestMapping("/createBoard")
	public String createBoard(Project project) {
		
		try {
			projectService.save(project);
		} catch (Exception e) {
			log.error("unable to save project", e);
			e.printStackTrace();
			return "error";
		}
		 return "redirect:/";
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
		 return "redirect:/";
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
		 return "redirect:/";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("project", new Project());
		model.addAttribute("name");
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
