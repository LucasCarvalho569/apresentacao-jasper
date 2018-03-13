package com.stefanini.apresentacaoJasper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stefanini.apresentacaoJasper.DTO.ClienteDTO;
import com.stefanini.apresentacaoJasper.converter.ClienteConverter;
import com.stefanini.apresentacaoJasper.repository.ClienteRepository;

public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public List<ClienteDTO> findAll() {
		return ClienteConverter.converterLista(clienteRepository.findAll());
	}
}
