package com.cg.fms.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Course;
import com.cg.fms.entities.Employee;
import com.cg.fms.exceptions.IncorrectNameAndRoleException;
import com.cg.fms.repository.ITrainerManagementRepository;

import java.util.*;

@Service
public class ITrainerManagementServiceImpl implements ITrainerManagementService {

	@Autowired
	ITrainerManagementRepository itm;

	@Override
	public Employee addTrainer(Employee emp) throws IncorrectNameAndRoleException {
		if (validate(emp)) {
			throw new IncorrectNameAndRoleException("Special characters denied. Roles are predefined");
		} else {
			itm.save(emp);
			return emp;
		}
	}

	@Override
	public Employee updateTrainer(Employee emp) {
		itm.save(emp);
		return emp;
	}

	@Override
	public Employee removeTrainer(int id) {
		Optional<Employee> em = itm.findById(id);
		itm.deleteById(id);
		return em.get();
	}

	@Override
	public Employee viewTrainer(int id) {
		Optional<Employee> em = itm.findById(id);
		return em.get();
	}

	@Override
	public List<Employee> viewAllTrainers() {
		List<Employee> lst = itm.findAll();
		return lst;
	}

	public boolean validate(Employee emp) {
		Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
		if (emp.getEmployeeId() > 0) {
			if (emp.getRole().toString().equals("admin") || emp.getRole().toString().equals("user")) {
				java.util.regex.Matcher hasSpecial = special.matcher(emp.getEmpName());
				return hasSpecial.find();
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public String SignIn(int uid, String pw) {
		
		String pass= itm.getPassword(uid);
		if(pass.equals(pw))
		{
			return "Login Succesful";
		}
		else
		{
			return "Login failed";
		}
		
		
	}

	

}
