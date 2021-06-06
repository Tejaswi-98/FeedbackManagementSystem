package com.cg.fms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.fms.entities.Feedback;
import com.cg.fms.entities.Program;
import com.cg.fms.repository.IFeedbackRepository;
import com.cg.fms.service.IFeedbackService;
/**
 * 
 * @author user
 *
 */
@SpringBootTest
public class IFeedbackServiceTest {
	/**
	 * 
	 */
	@Autowired
	IFeedbackService feedbackService;
	/**
	 * 
	 */
	@MockBean
	IFeedbackRepository feedRepo;
/**
 * 	
 */
	@Test
	public void testAddFeedback() {
		Feedback feed=new Feedback();
		feed.setFeedback_Id(123);
		feed.setFeedbackCriteria1(8);
		feed.setFeedbackCriteria2(9);
		feed.setFeedbackCriteria3(8);
		feed.setFeedbackCriteria4(5);
		feed.setFeedbackCriteria5(6);
		feed.setSuggestions("Goood");
		feed.setComments("Wonderfull");
		Program pro = new Program();
		pro.setTrainingId(1);
		feed.setFeedback_Id(1);
		Mockito.when(feedRepo.save(feed)).thenReturn(feed);
		assertThat(feedbackService.addFeedback(feed)).isEqualTo(feed);
		
	}
	/**
	 * 
	 */
	@Test
	public void testUpdateFeedback() {
		Feedback feed=new Feedback();
		feed.setFeedback_Id(123);
		feed.setFeedbackCriteria1(8);
		feed.setFeedbackCriteria2(9);
		feed.setFeedbackCriteria3(8);
		feed.setFeedbackCriteria4(5);
		feed.setFeedbackCriteria5(6);
		feed.setSuggestions("Good");
		feed.setComments("Wonderful");
		Program pro = new Program();
		pro.setTrainingId(1);
		feed.setFeedback_Id(1);
		Mockito.when(feedRepo.findById(feed.getFeedback_Id())).thenReturn(Optional.of(feed));
		feed.setFeedbackCriteria1(5);
		Mockito.when(feedRepo.save(feed)).thenReturn(feed);
		assertThat(feedbackService.updateFeedback(feed)).isEqualTo(feed);
	}
	/**
	 * 
	 */
	@Test
	public void testViewProgramFeedback()
	{
		Feedback feed = new Feedback();
		feed.setFeedback_Id(123);
		feed.setFeedbackCriteria1(8);
		feed.setFeedbackCriteria2(9);
		feed.setFeedbackCriteria3(8);
		feed.setFeedbackCriteria4(5);
		feed.setFeedbackCriteria5(6);
		feed.setSuggestions("Good");
		feed.setComments("Wonderful");
		
		Program pro = new Program();
		pro.setTrainingId(123);
		pro.setStartDate(LocalDate.of(2020,1,8));
		pro.setEndDate(LocalDate.of(2020,1,28));
		Mockito.when(feedRepo.findById(feed.getFeedback_Id())).thenReturn(Optional.of(feed));
		  Mockito.when(feedRepo.existsById(pro.getTrainingId())).thenReturn(true);
		  assertTrue(feedRepo.existsById(feed.getFeedback_Id()));
	}
	@Test
	public void testViewTrainerFeedback()
	{
		Feedback feed = new Feedback();
		feed.setFeedback_Id(123);
		feed.setFeedbackCriteria1(8);
		feed.setFeedbackCriteria2(9);
		feed.setFeedbackCriteria3(8);
		feed.setFeedbackCriteria4(5);
		feed.setFeedbackCriteria5(6);
		feed.setSuggestions("Good");
		feed.setComments("Wonderful");
		
		Program pro = new Program();
		pro.setTrainingId(123);
		pro.setStartDate(LocalDate.of(2020,1,8));
		pro.setEndDate(LocalDate.of(2020,1,28));
		Mockito.when(feedRepo.findById(feed.getFeedback_Id())).thenReturn(Optional.of(feed));
		  Mockito.when(feedRepo.existsById(pro.getTrainingId())).thenReturn(true);
		  assertTrue(feedRepo.existsById(feed.getFeedback_Id()));
	}
	@Test
	public void testViewAllFeedbacks()
	{
		Feedback feed1 = new Feedback();
		feed1.setFeedback_Id(123);
		feed1.setFeedbackCriteria1(8);
		feed1.setFeedbackCriteria2(9);
		feed1.setFeedbackCriteria3(8);
		feed1.setFeedbackCriteria4(5);
		feed1.setFeedbackCriteria5(6);
		feed1.setSuggestions("Good");
		feed1.setComments("Wonderful");
		
		Program pro1 = new Program();
		pro1.setTrainingId(123);
		pro1.setStartDate(LocalDate.of(2020,1,8));
		pro1.setEndDate(LocalDate.of(2020,1,28));
		
		Feedback feed2 = new Feedback();
		feed2.setFeedback_Id(123);
		feed2.setFeedbackCriteria1(8);
		feed2.setFeedbackCriteria2(9);
		feed2.setFeedbackCriteria3(8);
		feed2.setFeedbackCriteria4(5);
		feed2.setFeedbackCriteria5(6);
		feed2.setSuggestions("Good");
		feed2.setComments("Wonderful");
		
		Program pro2 = new Program();
		pro2.setTrainingId(123);
		pro2.setStartDate(LocalDate.of(2020,1,8));
		pro2.setEndDate(LocalDate.of(2020,1,28));
		
		List<Feedback> feedback = new ArrayList<>();
		feedback.add(feed1); feedback.add(feed2);
		Mockito.when(feedRepo.findAll()).thenReturn(feedback);
		
		assertThat(feedbackService.viewAllFeedbacks()).isEqualTo(feedback);
	}
	@Test 
	public void testRemoveFeedback() {
		Feedback feed=new Feedback();
		feed.setFeedback_Id(123);
		feed.setFeedbackCriteria1(8);
		feed.setFeedbackCriteria2(9);
		feed.setFeedbackCriteria3(8);
		feed.setFeedbackCriteria4(5);
		feed.setFeedbackCriteria5(6);
		feed.setSuggestions("Good");
		feed.setComments("Wonderful");
		Program pro = new Program();
		pro.setTrainingId(1);
		feed.setFeedback_Id(1); 
		Mockito.when(feedRepo.existsById(feed.getFeedback_Id())).thenReturn(false);
	       assertFalse(feedRepo.existsById(feed.getFeedback_Id()));
	}
	@Test
	public void testValidate() {
		Feedback feed=new Feedback();
		feed.setFeedback_Id(123);
		feed.setFeedbackCriteria1(8);
		feed.setFeedbackCriteria2(9);
		feed.setFeedbackCriteria3(8);
		feed.setFeedbackCriteria4(5);
		feed.setFeedbackCriteria5(6);
		feed.setSuggestions("Good");
		feed.setComments("Wonderful");
		Program pro = new Program();
		pro.setTrainingId(1);
		feed.setFeedback_Id(1); 
		Mockito.when(feedRepo.existsById(feed.getFeedback_Id())).thenReturn(false);
	    assertThat(feedRepo.existsById(feed.getFeedback_Id()));
	}	
	
}