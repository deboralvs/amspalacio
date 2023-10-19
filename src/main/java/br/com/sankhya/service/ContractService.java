package br.com.sankhya.service;

import br.com.sankhya.entity.Contract;

import java.util.List;

public interface ContractService {

	public List<Contract> findContractByClass(String classCode);
}
