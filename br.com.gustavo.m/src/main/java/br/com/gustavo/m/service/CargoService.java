package br.com.gustavo.m.service;

import java.util.List;

import br.com.gustavo.m.domain.Cargo;

public interface CargoService {
	void salvar(Cargo cargo);
	void editar(Cargo cargo);
	void excluir(Long id);
	Cargo buscarPorId(Long id);
	
	List <Cargo> buscarTodos();
	boolean cargoTemFuncionario(Long id);
	
}
