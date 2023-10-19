package br.com.sankhya.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TCSPRJ")
public class Project {

	@Id
	@Column(name = "codproj")
	private Long id;

	@Column(name = "identificacao")
	private String projectName;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "codproj")
	private List<Contract> listContracts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Contract> getListContracts() {
		return listContracts;
	}

	public void setListContracts(List<Contract> listContracts) {
		this.listContracts = listContracts;
	}

}
