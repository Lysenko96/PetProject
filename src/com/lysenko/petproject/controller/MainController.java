package com.lysenko.petproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lysenko.petproject.dao.TaskDAO;
import com.lysenko.petproject.model.Task;

@Controller
public class MainController {

	@Autowired
	private TaskDAO taskDAO;

	@RequestMapping(value = "/")
	public ModelAndView listTask(ModelAndView model) {
		List<Task> listTask = taskDAO.list();
		model.addObject("listTask", listTask);
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newTask(ModelAndView model) {
		Task newTask = new Task();
		model.addObject("task", newTask);
		model.setViewName("task_form");
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveTask(@ModelAttribute Task task) {
		if (task.getId() == null) {
			taskDAO.save(task);
		} else {
			taskDAO.update(task);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editTask(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Task task = taskDAO.get(id);
		ModelAndView model = new ModelAndView("task_form");
		model.addObject("task", task);
		// model.setViewName("task_form");
		return model;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteTask(@RequestParam Integer id) {
		taskDAO.delete(id);
		return new ModelAndView("redirect:/");
	}

}
