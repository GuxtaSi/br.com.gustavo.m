package br.com.gustavo.m.dao;

import org.springframework.stereotype.Repository;

import br.com.gustavo.m.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao < Funcionario , Long> implements FuncionarioDao {

}
