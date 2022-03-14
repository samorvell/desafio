package com.desafioserasa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafioserasa.entity.ScoreEntity;

@Service
public interface ScoreService {

	List<ScoreEntity> findAll();
}
