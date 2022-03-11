package com.desafioserasa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.desafioserasa.entity.PessoaEntity;

@Service
public interface PessoaService {

		List<PessoaEntity> findAll();

	/**
	 * Persiste um funcionário na base de dados.
	 * 
	 * @param funcionario
	 * @return Funcionario
	 */
	PessoaEntity persistir(PessoaEntity pessoaEntity);

	/**
	 * Retorna um lançamento por ID.
	 * 
	 * @param id
	 * @return Optional<PessoaEntity>
	 */
	Optional<PessoaEntity> buscarPorId(Long id);

}
