package com.demo.Entity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employees")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Column(nullable = false)
	String firstname;
	
	@Column(nullable = false)
	String lastname;
	
	@Column
	@Email(message = "Enter Valid Email")
	String email;
	
	@Column
	@Digits(integer = 10, fraction = 0, message = "Phone number must contain exactly 10 digits")
	@NotNull
	long ph;
	
	@Column(nullable = false)
	String jobrole;
	
	@Column
	long salary;
	
	public EmployeeEntity() {
	
	}
	
	public EmployeeEntity(long id, String firstname, String lastname, String email, long ph, String jobrole,
			long salary) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.ph = ph;
		this.jobrole = jobrole;
		this.salary = salary;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPh() {
		return ph;
	}
	public void setPh(long ph) {
		this.ph = ph;
	}
	public String getJobrole() {
		return jobrole;
	}
	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
}
