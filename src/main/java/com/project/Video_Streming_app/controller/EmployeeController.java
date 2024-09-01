package com.project.Video_Streming_app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.Video_Streming_app.model.Employee;
import com.project.Video_Streming_app.service.EmployeeService;
import com.project.Video_Streming_app.utl.CapthaUtil;

import cn.apiclub.captcha.Captcha;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	private void setUpCaptch(Employee employee) throws IOException {
		Captcha captcha = CapthaUtil.createCaptcha(200, 80);
		employee.setHiddenValue(captcha.getAnswer());
		employee.setCaptcha("");
		employee.setCaptcha(CapthaUtil.encodedDataBase64(captcha));
	}

	@GetMapping("/register")
	public String showReg(Model model) throws IOException {
		Employee employee = new Employee();
		setUpCaptch(employee);
		model.addAttribute("employee", employee);
		return "employeeReg";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Employee employee, Model model) throws IOException {
		employeeService.createEmployee(employee);
		model.addAttribute("message", "employee created");
		if (employee.getCaptcha().equals(employee.getHiddenValue())) {
			employeeService.createEmployee(employee);
			model.addAttribute("message", "employee created");
		} else {
			setUpCaptch(employee);
			model.addAttribute("employee", employee);
		}
		Employee employee1 = new Employee();

		return "employeeReg";
	}
}
