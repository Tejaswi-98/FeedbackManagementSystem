package com.cg.fms.service;

import com.cg.fms.entities.Employee;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public interface ITrainerManagementService {
	
	public String SignIn(int uid, String pw);
	
	public Employee addTrainer(Employee emp);
	
	public Employee updateTrainer(Employee emp);
	
	public Employee removeTrainer(int id);
	
	public Employee viewTrainer(int id);
	
	public List<Employee> viewAllTrainers();
	
}
