package com.ssa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="ssn_enrollment" ,schema = "SSNPortal")
public class SSNEnrollmentEntity {
	
	private Long ssnNumber;
	private String firstname;
	private String lastname;
	private String gender;
	private Date dob;
	private String state;
	private Date createdDate;
	private Date updatedDate;
	
	
	@Id
	@GenericGenerator(name = "ssn_id_seq" ,strategy = "com.ssa.generator.SSNGenerator")
	@GeneratedValue(generator = "ssn_id_seq")
	//@GeneratedValue
	public Long getSsnNumber() {
		return ssnNumber;
	}
	public void setSsnNumber(Long ssnNumber) {
		this.ssnNumber = ssnNumber;
	}
	
	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Column(name = "gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Column(name = "state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "createdDate" , updatable = false)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
    @UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "updatedDate" , insertable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "SSNEnrollmentEntity [ssnNumber=" + ssnNumber + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", gender=" + gender + ", dob=" + dob + ", state=" + state + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}
	
	
	
	

}
