package com.desafioserasa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafioserasa.entity.PessoaEntity;



public interface PessoaRepository extends JpaRepository<PessoaEntity, Long>{

	List<PessoaEntity> findAll();
}
