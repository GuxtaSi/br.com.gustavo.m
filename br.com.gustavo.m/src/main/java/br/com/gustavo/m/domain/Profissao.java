package br.com.gustavo.m.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name ="PROFISSOES")
public class Profissao extends abstractEntity<Long> {
	
	@Column(name = "nome" , nullable= false , unique = true, length = 60 )
	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_empresa_fk")
	private Empresa empresa;
	@OneToMany(mappedBy = "profissao")
	private List<Cliente> funcionarios;

	public List<Cliente> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Cliente> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	
}
