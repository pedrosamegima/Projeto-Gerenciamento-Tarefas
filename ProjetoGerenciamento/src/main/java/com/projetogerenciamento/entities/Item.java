package com.projetogerenciamento.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table (name = "Item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@Column(name = "nome")
	private String nome;

	@Future
	@Column(name = "dataLimiteExecucao")
	private String dataLimiteExecucao;

	@NotBlank
	@NotNull
	@Column(name = "datelhesTarefa")
	private String detalhesTarefa;

	@NotBlank
	@NotNull
	@Column(name = "statusTarefa")
	private String statusTarefa;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataLimiteExecucao() {
		return dataLimiteExecucao;
	}
	public void setDataLimiteExecucao(String dataLimiteExecucao) {
		this.dataLimiteExecucao= dataLimiteExecucao;
	}
	public String getDetalhesTarefa() {
		return detalhesTarefa;
	}
	public void setDetalhesTarefa(String detalhesTarefa) {
		this.detalhesTarefa = detalhesTarefa;
	}

	public String getStatusTarefa() {
		return statusTarefa;
	}
	public void setStatusTarefa(String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}


}


