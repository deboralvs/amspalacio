package br.com.sankhya.service.impl;

import br.com.sankhya.entity.HttpResponse;
import br.com.sankhya.repository.ProjectRepository;
import br.com.sankhya.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository repository;
	
	@Override
	public HttpResponse findByProjectId(Long projectId) {
		if(projectId != null)
		return new HttpResponse(200,repository.findById(projectId));
		return new HttpResponse(200,repository.findAll());
	}

}
