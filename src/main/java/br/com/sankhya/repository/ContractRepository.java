package br.com.sankhya.repository;

import br.com.sankhya.entity.Contract;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContractRepository extends CrudRepository<Contract, Long>{

	public List<Contract> findByClassCode(String classCode);
	
}
