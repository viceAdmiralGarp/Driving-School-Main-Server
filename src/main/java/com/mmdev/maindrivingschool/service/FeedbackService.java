package com.mmdev.maindrivingschool.service;

import com.mmdev.maindrivingschool.entity.Feedback;
import com.mmdev.maindrivingschool.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {

	private final FeedbackRepository feedbackRepository;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	public Feedback createFeedback(Feedback feedback, String ipAddress) {
		if (feedbackRepository.countByIpAddress(ipAddress) >= 2) {
			throw new IllegalArgumentException("You cannot post more than 2 comments.");
		}
		feedback.setIpAddress(ipAddress);
		feedback.setCreatedAt(new Date());
		return feedbackRepository.save(feedback);
	}

	public List<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}
}