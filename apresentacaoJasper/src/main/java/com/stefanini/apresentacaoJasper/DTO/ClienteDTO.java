package com.stefanini.apresentacaoJasper.DTO;

import java.util.Date;

public class ClienteDTO {
	private Integer id;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private FilmeDTO filme;
	
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
	public FilmeDTO getFilme() {
		return filme;
	}
	public void setFilme(FilmeDTO filme) {
		this.filme = filme;
	}
}
