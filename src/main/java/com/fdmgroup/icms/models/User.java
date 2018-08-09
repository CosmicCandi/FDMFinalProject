package com.fdmgroup.icms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fdmgroup.icms.enums.Department;
import com.fdmgroup.icms.enums.UserRole;

@Entity
@Table(name="icms_user")
@SequenceGenerator(name="user_id_seq", initialValue=1, allocationSize=1)
public class User {

	
	public User(){}
	
	public User(String username, String password, String email, UserRole role, Department departmentId){
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.departmentId = departmentId;		
	}
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_id_seq")
	private int userId;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Column
	private UserRole role;
	
	@Column 
	private Department departmentId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Department getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}

	public int getUserId() {
		return userId;
	}
	

}
