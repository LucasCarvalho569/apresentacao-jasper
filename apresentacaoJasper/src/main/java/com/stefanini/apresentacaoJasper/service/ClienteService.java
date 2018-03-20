package com.stefanini.apresentacaoJasper.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import com.stefanini.apresentacaoJasper.DTO.ClienteDTO;
import com.stefanini.apresentacaoJasper.converter.ClienteConverter;
import com.stefanini.apresentacaoJasper.repository.ClienteRepository;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public InputStreamResource gerarRelatorio() throws JRException {
		List<ClienteDTO> clientesDTO = ClienteConverter.converterLista(clienteRepository.findAll());
		JRBeanCollectionDataSource bcds = new JRBeanCollectionDataSource(clientesDTO);
		Map<String, Object> params = new HashMap<>();
		params.put("ItemDataSource", bcds);
		InputStream is = ClienteService.class.getClassLoader().getResourceAsStream("relatorio/SemTemplate_ComTabela.jrxml");
		JasperDesign jd = JRXmlLoader.load(is);
		JasperReport report = JasperCompileManager.compileReport(jd);
		JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
		return new InputStreamResource(new ByteArrayInputStream(JasperExportManager.exportReportToPdf(print)));
	}

	public InputStreamResource gerarRelatorioComParametro(String mensagem) throws JRException {
		List<ClienteDTO> clientesDTO = ClienteConverter.converterLista(clienteRepository.findAll());
		JRBeanCollectionDataSource bcds = new JRBeanCollectionDataSource(clientesDTO);
		Map<String, Object> params = new HashMap<>();
		params.put("ItemDataSource", bcds);
		params.put("mensagem", mensagem);
		InputStream is = ClienteService.class.getClassLoader().getResourceAsStream("relatorio/SemTemplate_ComTabela.jrxml");
		JasperDesign jd = JRXmlLoader.load(is);
		JasperReport report = JasperCompileManager.compileReport(jd);
		JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
		return new InputStreamResource(new ByteArrayInputStream(JasperExportManager.exportReportToPdf(print)));
	}
}
