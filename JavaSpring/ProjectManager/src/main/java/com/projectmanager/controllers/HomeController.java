package com.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectmanager.models.Project;
import com.projectmanager.models.Task;
import com.projectmanager.models.User;
import com.projectmanager.services.ProjectsService;
import com.projectmanager.services.TaskService;
import com.projectmanager.services.UserService;

@Controller
public class HomeController {
	
    @Autowired
    private UserService userService;
	
	@Autowired
	ProjectsService projectsService;
	
	@Autowired
	TaskService taskService;
	
	@RequestMapping("/")
	public String rootRedirect(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		return "redirect:/dashboard/";
	}
	
	@GetMapping("/dashboard")
	public String root(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUser(userId);
		
		model.addAttribute("user", user);
		model.addAttribute("notAssignedProjects", projectsService.getUnassignedUsers(user));
		model.addAttribute("AssignedProjects", projectsService.getAssignedUsers(user));
		
		return "dashboard.jsp";
	}
	
	@GetMapping("projects/new")
	public String createProject(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("projectModel", new Project());
		model.addAttribute("isEdit", false);
		
		return "editnew_project.jsp";
	}
	
	@PostMapping("projects/new")
	public String createProject(HttpSession session, Model model, @Valid @ModelAttribute("projectModel") Project project, BindingResult result) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("isEdit", false);
		
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUser(userId);
		
        if (result.hasErrors()) {
            return "editnew_project.jsp";
        } else {
        	project.setCreator(user);
        	//project.
        	projectsService.createProject(project);
            return "redirect:/dashboard/";
        }
	}
	
	@GetMapping("projects/{id}/edit")
	public String editProject(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("projectModel", projectsService.findProject(id));
		model.addAttribute("isEdit", true);
		
		return "editnew_project.jsp";
	}
	
	@PutMapping("projects/{id}/edit")
	public String editProject(@PathVariable("id") Long id, HttpSession session, Model model, @Valid @ModelAttribute("projectModel") Project project, BindingResult result) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("isEdit", true);
		
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUser(userId);
		
        if (result.hasErrors()) {
            return "editnew_project.jsp";
        } else {
        	project.setCreator(user);
        	projectsService.updateProject(project);
            return "redirect:/dashboard/";
        }
	}
	
	@GetMapping("projects/{id}")
	public String showProject(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUser(userId);
		
		model.addAttribute("projectModel", projectsService.findProject(id));
		
		return "show.jsp";
	}
	
	@DeleteMapping("projects/{id}/delete")
	public String deleteBook(@PathVariable("id") Long id, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Project project = projectsService.findProject(id);
		long userId = (Long) session.getAttribute("userId");
		
		if (project.getCreator().getId() == userId) {
			projectsService.deleteProject(id);
		}
		
		return "redirect:/dashboard/";
	}
	
	// join team
	@GetMapping("projects/{id}/join")
	public String joinProject(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUser(userId);
		
		Project project = projectsService.findProject(id);
		project.getJoinedUsers().add(user);
		projectsService.updateProject(project);
		
		return "redirect:/dashboard/";
	}
	
	// leave team
	@GetMapping("projects/{id}/leave")
	public String leaveProject(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUser(userId);
		
		Project project = projectsService.findProject(id);
		project.getJoinedUsers().remove(user);
		projectsService.updateProject(project);
		
		return "redirect:/dashboard/";
	}
	
	@GetMapping("/projects/{id}/tasks")
	public String showTasks(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUser(userId);
		
		Project project = projectsService.findProject(id);
		
		model.addAttribute("user", user);
		model.addAttribute("newTask", new Task());
		model.addAttribute("projectModel", projectsService.findProject(id));
		model.addAttribute("taskList", project.getTasks());
		
		return "showtask.jsp";
	}
	
	@PostMapping("/projects/{id}/tasks")
	public String createTasks(@PathVariable("id") Long id, HttpSession session, Model model, @Valid @ModelAttribute("newTask") Task newTask, BindingResult result) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		User user = userService.findUser((Long) session.getAttribute("userId"));
		Project project = projectsService.findProject(id);
		
		model.addAttribute("user", user);

		model.addAttribute("projectModel", project);
		model.addAttribute("taskList", project.getTasks());
		
        if (result.hasErrors()) {
        	
        	return "showtask.jsp";
        } else {
        	newTask.setId(null);
        	newTask.setCreator(user);
        	newTask.setProject(project);
        	taskService.createTask(newTask);

        	return "redirect:/projects/" + id + "/tasks";
        }
		
	}
	
}
