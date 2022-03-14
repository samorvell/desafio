package com.desafioserasa.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafioserasa.dtos.PessoaDto;
import com.desafioserasa.dtos.ScoreDto;
import com.desafioserasa.dtos.TodosPessoaDto;
import com.desafioserasa.entity.PessoaEntity;
import com.desafioserasa.entity.ScoreEntity;
import com.desafioserasa.repository.PessoaRepository;
import com.desafioserasa.repository.ScoreRepository;
import com.desafioserasa.response.Response;
import com.desafioserasa.service.PessoaService;

@Controller
@RequestMapping
public class PessoaController {

	private static final Logger log = LoggerFactory.getLogger(PessoaController.class);

	@Autowired
	private final PessoaService pessoaService;

	@Autowired
	private final PessoaRepository pessoaRepository;
	
	@Autowired
	private final ScoreRepository scoreRepository;

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	public PessoaController(PessoaService pessoaService, PessoaRepository pessoaRepository, ScoreRepository scoreRepository) {
		this.pessoaService = pessoaService;
		this.pessoaRepository = pessoaRepository;
		this.scoreRepository = scoreRepository;

	}

	/**
	 * Cadastra uma pessoa na base de dados.
	 * 
	 */

	@PostMapping(value = "/pessoa")
	public ResponseEntity<?> cadastrar(@Valid @RequestBody PessoaDto cadastroPessoaDto, BindingResult result)
			throws NoSuchAlgorithmException {
		log.info("Cadastrando Pessoa: {}", cadastroPessoaDto.toString());
		Response<PessoaDto> response = new Response<PessoaDto>();

		PessoaEntity pessoa = this.converterDtoParaPessoaEntity(cadastroPessoaDto, result);

		if (result.hasErrors()) {
			log.error("Erro validando dados de cadastro PF: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		var pessoaSalva = this.pessoaService.persistir(pessoa);
		response.setData(this.converterCadastroPessoaDto(pessoaSalva));

		return new ResponseEntity<>(converterCadastroPessoaDto(pessoaSalva), HttpStatus.CREATED);

	}

	/**
	 * Retorna uma empresa dado um ID.
	 * 
	 * @param cnpj
	 * @return ResponseEntity<Response<EmpresaDto>>
	 */

	@GetMapping(value = "/pessoa/{id}")
	public ResponseEntity<Response<PessoaDto>> buscarPorId(@PathVariable("id") Long id) {
		log.info("Buscando pessoa por id: {}", id);
		Response<PessoaDto> response = new Response<PessoaDto>();
		Response<ScoreDto> respScore = new Response<ScoreDto>();
		
 		Optional<PessoaEntity> pessoa = pessoaService.buscarPorId(id);

		if (!pessoa.isPresent()) {
			log.info("Pessoa não encontrada para o Id: {}", id);
			response.getErrors().add("Pessoa não encontrada para o Id " + id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}

		response.setData(this.converterPessoaIdDto(pessoa.get()));
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/pessoa")
	public ResponseEntity<Response<List<TodosPessoaDto>>> findAll() {

		List<PessoaEntity> pessoas = pessoaRepository.findAll();
		Response<List<TodosPessoaDto>> todosResponse = new Response<List<TodosPessoaDto>>();
		var todosPessoasDTO = pessoas.stream().map(this::converterTodosPessoaDto).collect(Collectors.toList());
		todosResponse.setData(todosPessoasDTO);

		return ResponseEntity.ok(todosResponse);
	}

	/**
	 * Converte os dados do DTO para pessoa.
	 * 
	 * @param cadastroPessoaDto
	 * @param result
	 * @return pessoa
	 * @throws NoSuchAlgorithmException
	 */
	private PessoaEntity converterDtoParaPessoaEntity(PessoaDto cadastroPessoaDto, BindingResult result)
			throws NoSuchAlgorithmException {
		PessoaEntity pessoa = new PessoaEntity();
		pessoa.setId(cadastroPessoaDto.getId());
		pessoa.setNome(cadastroPessoaDto.getNome());
		pessoa.setTelefone(cadastroPessoaDto.getTelefone());
		pessoa.setIdade(cadastroPessoaDto.getIdade());
		pessoa.setCidade(cadastroPessoaDto.getCidade());
		pessoa.setEstado(cadastroPessoaDto.getEstado());
		pessoa.setScore(cadastroPessoaDto.getScore());

		return pessoa;
	}

	/**
	 * Popula o DTO de cadastro com os dados do funcionário e empresa.
	 * 
	 * @param funcionario
	 * @return CadastroPFDto
	 */
	private PessoaDto converterCadastroPessoaDto(PessoaEntity pessoaEntity) {
		PessoaDto cadastroPessoaDto = new PessoaDto();
		cadastroPessoaDto.setNome(pessoaEntity.getNome());
		cadastroPessoaDto.setTelefone(pessoaEntity.getTelefone());
		cadastroPessoaDto.setIdade(pessoaEntity.getIdade());
		cadastroPessoaDto.setScore(pessoaEntity.getScore());

		return cadastroPessoaDto;
	}

	private PessoaDto converterPessoaIdDto(PessoaEntity pessoaEntity) {
		PessoaDto consultaPessoaDto = new PessoaDto();
		consultaPessoaDto.setId(pessoaEntity.getId());
		consultaPessoaDto.setNome(pessoaEntity.getNome());
		consultaPessoaDto.setTelefone(pessoaEntity.getTelefone());
		consultaPessoaDto.setIdade(pessoaEntity.getIdade());
		consultaPessoaDto.setCidade(pessoaEntity.getCidade());
		consultaPessoaDto.setEstado(pessoaEntity.getEstado());
		
		
		//consultaPessoaDto.setScore(pessoaEntity.getScore());

		return consultaPessoaDto;
	}

	private TodosPessoaDto converterTodosPessoaDto(PessoaEntity pessoaEntity) {
		TodosPessoaDto cadastroPessoaDto = new TodosPessoaDto();
		cadastroPessoaDto.setNome(pessoaEntity.getNome());
		cadastroPessoaDto.setCidade(pessoaEntity.getCidade());
		cadastroPessoaDto.setEstado(pessoaEntity.getEstado());
		cadastroPessoaDto.setScore(pessoaEntity.getScore());

		return cadastroPessoaDto;
	}

		
}
