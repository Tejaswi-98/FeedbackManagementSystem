package com.cg.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.Employee;
import com.cg.fms.service.ITrainerManagementService;

import java.util.*;

@RestController
@RequestMapping("Fms/api")
public class EmployeeController {

	@Autowired
	ITrainerManagementService itm;

	@PostMapping("/Trainer")
	public Employee addTrainer(Employee emp) {
		return itm.addTrainer(emp);
	}

	@GetMapping("/TrAll")
	public List<Employee> viewAllEmployees() {
		return itm.viewAllTrainers();
	}

	@GetMapping("/TrainerView")
	public Employee viewEmployee(int id) {
		return itm.viewTrainer(id);
	}

	@PutMapping("/TrUpdate")
	public Employee updateEmployee(Employee emp) {
		return itm.updateTrainer(emp);
	}

	@DeleteMapping("/TrRemove")
	public Employee removeEmployee(int id) {
		return itm.removeTrainer(id);
	}
	
	@GetMapping("/SignIn")
	public String signIn(int uid, String pw)
	{
		return itm.SignIn(uid, pw);
	}
}
