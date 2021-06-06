package com.cg.fms.service;

import org.springframework.stereotype.Service;
import java.util.*;

import com.cg.fms.entities.Feedback;
import com.cg.fms.entities.Program;

@Service
public interface IFeedbackService {

	public Feedback addFeedback(Feedback fbb);

	public Feedback updateFeedback(Feedback fbb);

	public List<Feedback> viewProgramFeedback(int id);
	
	public List<Feedback> viewTrainerFeedback(int id);
	
	public List<Feedback> viewAllFeedbacks();
	
	public Feedback removeFeedback(int id);

}
