package com.stefanini.apresentacaoJasper.converter;

import com.stefanini.apresentacaoJasper.DTO.FilmeDTO;
import com.stefanini.apresentacaoJasper.model.Filme;

public class FilmeConverter {

	public static FilmeDTO converter(Filme filme) {
		FilmeDTO filmeDTO = new FilmeDTO();
		filmeDTO.setId(filme.getId());
		filmeDTO.setNome(filme.getNome());
		return filmeDTO;
	}
	
	public static Filme converter(FilmeDTO filmeDTO) {
		Filme filme = new Filme();
		filme.setId(filmeDTO.getId());
		filme.setNome(filmeDTO.getNome());
		return filme;
	}
}
