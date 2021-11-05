package br.com.gustavo.m.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario extends abstractEntity<Long> {
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(nullable = false, columnDefinition="DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal salario;

	@Column(name ="data_saida", columnDefinition="DATE")
	private LocalDate dataSaida;
	
	@OneToOne
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn
	private Cargo cargo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
}
