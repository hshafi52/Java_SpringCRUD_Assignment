package com.uxpsystems.assignment.controller

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uxpsystems.assignment.dao.UserDaoImpl;
import com.uxpsystems.assignment.model.Employee;
import com.uxpsystems.assignment.model.Login;
import com.uxpsystems.assignment.model.User;
import com.uxpsystems.assignment.service.EmployeeService;
import com.uxpsystems.assignment.service.UserService;

@Controller
@RequestMapping("/assignement")
public class AppController {

	@Autowired
	EmployeeService service;

	@Autowired
	UserService userService;
	@Autowired
	UserDaoImpl userDao;

	 

	/*
	 * This method will be called to fetch user
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String listEmployeesbyID(ModelMap model, @PathVariable int id) {

		Employee employees = service.findById(id);
		System.out.println("Details of employee by ID  are" + employees);
		model.addAttribute("employeesbyid", employees);
		return "EmployeeByID";
	}

	/*
	 * This method will help user to login
	 */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(@RequestParam("username") String username,
			@RequestParam("password") String password) throws SQLException {

		ModelAndView mav = new ModelAndView("welcome");

		boolean isValid = userService.findAllEmployees(username, password);
		System.out.println("Is user valid ?= " + isValid);

		if (isValid = false) {

			// mav = new ModelAndView("welcome");
			mav.addObject("firstname", "wrong credentials");

		}

		if (isValid = true) {

			// mav = new ModelAndView("welcome");
			mav.addObject("firstname", username);

		}

		return mav;

	}

	

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editEmployee(@PathVariable int id, ModelMap model) {
		Employee employee = service.findById(id);
		// model.addAttribute("employee", employee);

		model.addAttribute("edit", employee);
		return "registration";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	
	public String updateEmployee(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("employee") Employee employee, ModelMap model) {
		ModelAndView mav;
		
		  if (employee.getId() != 0) {
		 
		service.updateEmployee(employee);
		
		return "viewemp";
	}
	
	
	  //This method will delete an employee by it's id.
	 
	  @RequestMapping(value = { "/delete/{id}" }, method =
	  RequestMethod.DELETE) public String deleteEmployee(@PathVariable int id) {
	  service.deleteEmployee(id); return "redirect:/list"; 
	  }
	 

}
