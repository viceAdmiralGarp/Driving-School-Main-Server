package com.mmdev.maindrivingschool.controller;

import com.mmdev.maindrivingschool.entity.Feedback;
import com.mmdev.maindrivingschool.service.FeedbackService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class FeedbackController {

	private final FeedbackService feedbackService;

	@GetMapping
	public List<Feedback> getAllFeedback() {
		return feedbackService.getAllFeedback();
	}

	@PostMapping
	public ResponseEntity<?> createFeedback(@RequestBody Feedback feedback, HttpServletRequest request) {
		String ipAddress = request.getRemoteAddr();
		try {
			Feedback createdFeedback = feedbackService.createFeedback(feedback, ipAddress);
			return new ResponseEntity<>(createdFeedback, HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}