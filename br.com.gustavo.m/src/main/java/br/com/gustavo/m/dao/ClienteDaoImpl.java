package br.com.gustavo.m.dao;

import org.springframework.stereotype.Repository;

import br.com.gustavo.m.domain.Cliente;

@Repository
public class ClienteDaoImpl extends AbstractDao < Cliente , Long> implements ClienteDao {

}
