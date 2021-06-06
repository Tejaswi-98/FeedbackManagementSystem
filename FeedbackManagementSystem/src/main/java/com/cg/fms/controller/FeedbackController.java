package com.cg.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.Feedback;
import com.cg.fms.entities.Program;
import com.cg.fms.service.IFeedbackService;

@RestController
@RequestMapping("Fms/api")
public class FeedbackController {

	@Autowired
	IFeedbackService ibf;

	@PostMapping("/Feedback")
	public Feedback addFeedback(@RequestBody Feedback fbb) {
		return ibf.addFeedback(fbb);
	}

	@PostMapping("/FeedbackUp")
	public Feedback updateFeedback(@RequestBody Feedback fbb) {
		return ibf.updateFeedback(fbb);
	}
	
	@GetMapping("/FeedbackAll")
	public List<Feedback> viewAllFeedbacks() {
		return ibf.viewAllFeedbacks();
	}

	@GetMapping("/FeedbackPr")
	public List<Feedback> viewProgramFeedback(int id) {
		return ibf.viewProgramFeedback(id);
	}
	
	@GetMapping("/FeedbackTr")
	public List<Feedback> viewTrainerFeedback(int id) {
		return ibf.viewTrainerFeedback(id);
	}
	
	@DeleteMapping("/FeedbackRem")
	public Feedback removeFeedback(int id)
	{
		return ibf.removeFeedback(id);
	}

}
