package com.sahil.springjwt.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="enquiry")
@Setter
@Getter
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long enquiryId;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	private String enquiryTitle;
	
	@CreationTimestamp
	@Column(updatable = true)
	private Date enquiryDate;
	
	private String enquirySource;
	
	private String enquiryStatus;
	
	@ManyToMany
	@JoinTable(name="ownerWithEnquiry")
	private List<User> user;
	
	
}
