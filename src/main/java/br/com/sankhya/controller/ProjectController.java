package br.com.sankhya.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sankhya.entity.Contract;
import br.com.sankhya.entity.HttpResponse;
import br.com.sankhya.service.ContractService;
import br.com.sankhya.service.ProjectService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {

	@Autowired 
	private ProjectService projectService;
	
	@Autowired
	private ContractService contractService;
	
	@GetMapping
	public HttpResponse getProject(@RequestParam(required = false) Long projectId) {
		
			return projectService.findByProjectId(projectId);
		
	}
	
	@GetMapping("/firstLogin")
	public ResponseEntity<Object> isFirstLogin(@RequestParam String classCode) {

		try {
			List<Contract> userEntity = contractService.findContractByClass(classCode);
			// TODO Get ListContract x Class X CPF
			if (userEntity.size() == 0)
				throw new UsernameNotFoundException("invalid class code");
		} catch (UsernameNotFoundException ex) {
			Map<String, Object> jo = new HashMap<String, Object>();
			jo.put("Status", 400);
			jo.put("Message", ex.getMessage());
			return new ResponseEntity<Object>(jo, HttpStatus.OK);
		}

		Map<String, Object> jo = new HashMap<String, Object>();
		jo.put("Status", 200);
		jo.put("Message", "class code is valid");
		return new ResponseEntity<Object>(jo, HttpStatus.OK);
	}
}
