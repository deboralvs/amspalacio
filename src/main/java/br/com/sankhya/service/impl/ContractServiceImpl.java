package br.com.sankhya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sankhya.entity.Contract;
import br.com.sankhya.repository.ContractRepository;
import br.com.sankhya.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractRepository repository;

	
	@Override
	public List<Contract> findContractByClass(String classCode) {
		List<Contract> contracts = repository.findByClassCode(classCode);
		if (contracts.isEmpty()){
			throw new UsernameNotFoundException("not found");
		}
		return contracts;
	}



}
