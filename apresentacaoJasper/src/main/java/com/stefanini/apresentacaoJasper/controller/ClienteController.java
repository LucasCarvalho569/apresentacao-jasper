package com.stefanini.apresentacaoJasper.controller;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.apresentacaoJasper.service.ClienteService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<InputStreamResource> gerarRelatorio() throws IOException, JRException {
		return ResponseEntity.ok()
				.headers(construirHeaders("SemTemplate_ComTabela" + new Date()))
				.contentLength(clienteService.gerarRelatorio().contentLength())
				.contentType(MediaType.APPLICATION_PDF)
				.body(clienteService.gerarRelatorio());
	}
	
	@GetMapping("{mensagem}")
	public ResponseEntity<InputStreamResource> gerarRelatorioComParametro(@PathVariable String mensagem) throws IOException, JRException {
		return ResponseEntity.ok()
				.headers(construirHeaders("SemTemplate_ComTabela" + new Date()))
				.contentLength(clienteService.gerarRelatorioComParametro(mensagem).contentLength())
				.contentType(MediaType.APPLICATION_PDF)
				.body(clienteService.gerarRelatorioComParametro(mensagem));
	}
	
	private HttpHeaders construirHeaders(String fileName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.add("Content-Disposition", "attachment;filename=" + fileName);
		headers.add("Access-Control-Expose-Headers", "Content-Disposition");
		return headers;
	}
}
