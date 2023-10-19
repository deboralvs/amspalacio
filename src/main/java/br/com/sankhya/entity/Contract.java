package br.com.sankhya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tcscon")
public class Contract {

	@Id
	@Column(name = "numcontrato")
	private Long contractNumber;
	
	@Column(name = "codproj")
	private Long projectCode;
	
	@Column(name = "AD_DTINIFLUXO")
	private LocalDate startDate;
	
	@Column(name = "AD_DTFINFLUXO")
	private LocalDate endDate;

	@Column(name = "AD_CODTURMA")
	private String classCode;
	
	public Long getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(Long contractNumber) {
		this.contractNumber = contractNumber;
	}

	public Long getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(Long projectCode) {
		this.projectCode = projectCode;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}


}
