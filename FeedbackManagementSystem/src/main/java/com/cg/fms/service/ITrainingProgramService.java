package com.cg.fms.service;

import com.cg.fms.entities.Program;

import java.time.LocalDate;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public interface ITrainingProgramService {
	
	public Program createProgram(Program p);
	
	public Program updateProgram(Program p);
	
	public Program removeProgram(int id);
	
	public Program viewProgram(int id);
	
	public List<Program> viewAllPrograms();
	
	public Program viewAllProgramsByFaculty(int empid);

}
