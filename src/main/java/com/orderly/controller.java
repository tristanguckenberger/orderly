package com.orderly;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.orderly.dto.Cols;
import com.orderly.dto.Project;
import com.orderly.dto.Task;
import com.orderly.service.IColumnService;
import com.orderly.service.IProjectService;
import com.orderly.service.ITaskService;
import org.slf4j.Logger;

@Controller
public class controller {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IProjectService projectService;
	
	@Autowired
	private ITaskService taskService;
	
	@Autowired
	private IColumnService columnService;
	
	@RequestMapping("/createBoard")
	public String createBoard(Project project) {
		try {
			Project savedProject = projectService.save(project);
			return "redirect:/board/" + savedProject.getId();
		} catch (Exception e) {
			log.error("unable to save project", e);
			e.printStackTrace();
			return "error";
		}
	}
		
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
		
	@RequestMapping("/createColumn")
	public String createColumn(Cols cols) {
		cols.setName("project1");
		try {
			columnService.save(cols);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		 return "redirect:/";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home(Model model) {
		Iterable<Project> allProjects;
		try {
			allProjects = projectService.fetchAll();
	        ModelAndView mav = new ModelAndView("home");
	        mav.addObject("project", new Project());
	        mav.addObject("allProjects", allProjects);
	        return mav;
		} catch (Exception e) {
	        ModelAndView mav = new ModelAndView("error");
			e.printStackTrace();
			return mav;
		}
	}

	@GetMapping("/board/{id}")
	public ModelAndView project(@PathVariable("id") int projectId) {
        ModelAndView mav = new ModelAndView("board");
        mav.addObject("project", projectService.fetchById(projectId));
        return mav;
	}
	
	@PostMapping("/board")
	public ModelAndView project(@ModelAttribute Project project) {
        ModelAndView mav = new ModelAndView("board");
        mav.addObject("project", projectService.fetchById(project.getId()));
        return mav;
	}
	
	@RequestMapping("/searchResults")
	public String results() {
		return "searchResults";
	}
}
