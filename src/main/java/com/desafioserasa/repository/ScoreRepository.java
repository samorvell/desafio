package com.desafioserasa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafioserasa.entity.ScoreEntity;

public interface ScoreRepository extends JpaRepository<ScoreEntity, Long>{
	
	List<ScoreEntity> findAll();

}
