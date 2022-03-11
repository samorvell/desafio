package com.desafioserasa.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioserasa.entity.PessoaEntity;
import com.desafioserasa.repository.PessoaRepository;
import com.desafioserasa.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

	private static final Logger log = LoggerFactory.getLogger(PessoaServiceImpl.class);

	@Autowired
	private PessoaRepository pessoaRepository;

	public PessoaEntity persistir(PessoaEntity pessoaEntity) {
		log.info("Persistindo pessoa: {}", pessoaEntity);
		return this.pessoaRepository.save(pessoaEntity);
	}

	public Optional<PessoaEntity> buscarPorId(Long id) {
		log.info("Buscando pessoa pelo ID {}", id);
		PessoaEntity resposta = this.pessoaRepository.getById(id);
		return Optional.ofNullable(resposta);
	}

	public List<PessoaEntity> findAll() {
		return pessoaRepository.findAll();

	}

}
