package br.com.gustavo.m.service;

import java.util.List;

import br.com.gustavo.m.domain.Profissao;

public interface ProfissaoService {
	void salvar(Profissao profissao);
	void editar(Profissao profissao);
	void excluir(Long id);
	Profissao buscarPorId(Long id);
	
	List <Profissao> buscarTodos();
	boolean profissaoTemFuncionario(Long id);
	
}
