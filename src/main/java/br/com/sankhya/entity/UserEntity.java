package br.com.sankhya.entity;

import java.time.LocalDateTime;


public class UserEntity {

	private Long id;
	
	private String name;
	
	private String documentNumber;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String status;
	
	private String classCode;
	
	private String resetCode;
	
	private LocalDateTime limitDateCode;
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

		
	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getResetCode() {
		return resetCode;
	}

	public void setResetCode(String resetCode) {
		this.resetCode = resetCode;
	}

	public LocalDateTime getLimitDateCode() {
		return limitDateCode;
	}

	public void setLimitDateCode(LocalDateTime limitDateCode) {
		this.limitDateCode = limitDateCode;
	}

		
}
