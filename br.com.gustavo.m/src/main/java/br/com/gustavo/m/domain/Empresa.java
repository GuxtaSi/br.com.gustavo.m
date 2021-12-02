 package br.com.gustavo.m.domain;

import java.util.List;

import javax.persistence.*;
@SuppressWarnings("serial")
@Entity
@Table(name = "EMPRESAS")
public class Empresa extends abstractEntity<Long>{
	
	@Column(name = "nome" , nullable= false , unique = true, length = 60 )
	private String nome;
	
	@OneToMany(mappedBy = "empresa")
	private List<Profissao> profissao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Profissao> getProfissao() {
		return profissao;
	}

	public void setProfissao(List<Profissao> profissao) {
		this.profissao = profissao;
	}

}
