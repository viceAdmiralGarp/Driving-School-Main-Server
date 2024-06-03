package com.mmdev.maindrivingschool.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	private String name;
	private String message;
	private String ipAddress;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

}
