package br.com.gustavo.m.dao;
	
	import java.util.List;

import br.com.gustavo.m.domain.Funcionario;

	public interface  FuncionarioDao {
		
	void save( Funcionario departamento);

	void update( Funcionario departamento);

	void delete (Long id);

	 Funcionario findById(Long id);

	List<Funcionario>findAll();

}
