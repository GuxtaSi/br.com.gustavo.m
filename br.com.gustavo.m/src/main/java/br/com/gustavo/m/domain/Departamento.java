package br.com.gustavo.m.domain;

import java.util.List;

import javax.persistence.*;
@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends abstractEntity<Long>{
	
	@Column(name = "nome" , nullable= false , unique = true, length = 60 )
	private String nome;
	
	@OneToMany(mappedBy = "departamento")
	private List<Cargo> cargos;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}