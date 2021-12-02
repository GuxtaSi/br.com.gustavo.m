package br.com.gustavo.m.service;

import java.util.List;

import br.com.gustavo.m.domain. Empresa;

public interface EmpresaService {
		void salvar( Empresa empresa);
		
		void editar( Empresa empresa);
		
		void excluir(Long id);
		
		 Empresa buscarPorId(Long id);
		 
		List <Empresa> buscarTodos();
		
		

		boolean empresaTemProfissao(Long id);

		
}
