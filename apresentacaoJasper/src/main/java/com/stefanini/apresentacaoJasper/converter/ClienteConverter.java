package com.stefanini.apresentacaoJasper.converter;

import java.util.ArrayList;
import java.util.List;

import com.stefanini.apresentacaoJasper.DTO.ClienteDTO;
import com.stefanini.apresentacaoJasper.model.Cliente;

public class ClienteConverter {

	public static ClienteDTO converter(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setDataNascimento(cliente.getDataNascimento());
		clienteDTO.setFilme(FilmeConverter.converter(cliente.getFilme()));
		return clienteDTO;
	}
	
	public static Cliente converter(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setDataNascimento(clienteDTO.getDataNascimento());
		cliente.setFilme(FilmeConverter.converter(clienteDTO.getFilme()));
		return cliente;
	}
	
	public static List<ClienteDTO> converterLista(List<Cliente> clientes) {
		List<ClienteDTO> clienteDTO = new ArrayList<>();
		clientes.forEach(cliente -> {
			clienteDTO.add(converter(cliente));
		});
		
		return clienteDTO;
	}
}
