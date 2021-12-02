package br.com.gustavo.m.dao;

import java.util.List;

import br.com.gustavo.m.domain.Cargo;

public interface CargoDao {
			
	void save(Cargo cargo);

	void update(Cargo cargo);

	void delete (Long id);

	Cargo findById(Long id);

	List<Cargo>findAll();

}
