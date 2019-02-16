package com.example.team6.controller;

import com.example.team6.model.Cidade;
import com.example.team6.service.CidadeService;
import com.example.team6.service.exception.CidadeNaoEncontradoException;
import com.example.team6.service.exception.CidadeesExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cidades")
public class CidadeController
{
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cidade> buscar(@PathVariable("id") Long id) throws CidadeNaoEncontradoException
	{
		Cidade cidade = cidadeService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(cidade);
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Cidade>> listar() {

		return ResponseEntity.status(HttpStatus.OK).body(cidadeService.listar());
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public void salvar() throws CidadeesExistenteException
	{
		System.out.println("Passei Aqui !!");
		Cidade cidade = new Cidade();
		cidade.setId(1L);
		cidade.setDscCidade("Aracaju");
		cidadeService.salvar(cidade);
	}
	
	
	
	
	
}
