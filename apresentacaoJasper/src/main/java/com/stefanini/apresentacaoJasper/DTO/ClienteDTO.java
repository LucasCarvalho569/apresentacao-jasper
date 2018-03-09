package com.stefanini.apresentacaoJasper.DTO;

import java.util.Date;
import java.util.List;

public class ClienteDTO {
	private Integer id;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private List<FilmeDTO> filmes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public List<FilmeDTO> getFilmes() {
		return filmes;
	}
	public void setFilmes(List<FilmeDTO> filmes) {
		this.filmes = filmes;
	}
}
