package br.com.sankhya.service;

import br.com.sankhya.entity.HttpResponse;

public interface ProjectService {

	public HttpResponse findByProjectId(Long projectId);
}
