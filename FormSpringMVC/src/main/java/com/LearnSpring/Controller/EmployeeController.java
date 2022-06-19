package com.LearnSpring.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.LearnSpring.Model.Employee;

@Controller
public class EmployeeController {
	@RequestMapping(value = { "/", "/addEmployee" }, method = RequestMethod.GET)
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		List<String> listFavorite = new ArrayList<String>();
		listFavorite.add("Swimming");
		listFavorite.add("Listening music");
		listFavorite.add("Walking");
		listFavorite.add("Watching movie");
		listFavorite.add("Reading comic");
		model.addAttribute("listFavorite", listFavorite);
		List<String> listPosition = new ArrayList<String>();
		listPosition.add("Developer");
		listPosition.add("Designer");
		listPosition.add("Tester");
		listPosition.add("QA");
		model.addAttribute("listFavorite", listFavorite);
		model.addAttribute("listPosition", listPosition);
		return "add-employee";
	}

	@RequestMapping(value = {"/doAddEmployee" }, method = RequestMethod.GET)
	public String doAddEmployee(@RequestParam("name") String name, Model model) {
		Employee employee = new Employee();
		employee.setName(name);
		model.addAttribute("employee", employee);
		List<String> listFavorite = new ArrayList<String>();
		listFavorite.add("Swimming");
		listFavorite.add("Listening music");
		listFavorite.add("Walking");
		listFavorite.add("Watching movie");
		listFavorite.add("Reading comic");
		model.addAttribute("listFavorite", listFavorite);
		List<String> listPosition = new ArrayList<String>();
		listPosition.add("Developer");
		listPosition.add("Designer");
		listPosition.add("Tester");
		listPosition.add("QA");
		model.addAttribute("listFavorite", listFavorite);
		model.addAttribute("listPosition", listPosition);
		return "add-employee";
	}
	
	@RequestMapping("/redirect")
	public RedirectView  redirect(@RequestParam("name") String name, RedirectAttributes redirectAttributes) {
		System.out.println(name);
	    redirectAttributes.addAttribute("name", name);
	    return new RedirectView("doAddEmployee");
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String doAddEmployee(@ModelAttribute("employee") Employee employee, ModelMap modelMap) {
		modelMap.addAttribute("employee", employee);
		return "view-employee";
	}
}
