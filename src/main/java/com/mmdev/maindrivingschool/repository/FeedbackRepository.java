package com.mmdev.maindrivingschool.repository;

import com.mmdev.maindrivingschool.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long> {
	long countByIpAddress(String ipAddress);
}
