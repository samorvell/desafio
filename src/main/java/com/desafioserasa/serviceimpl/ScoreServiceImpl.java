package com.desafioserasa.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioserasa.entity.ScoreEntity;
import com.desafioserasa.repository.ScoreRepository;
import com.desafioserasa.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {

	private static final Logger log = LoggerFactory.getLogger(ScoreServiceImpl.class);

	@Autowired
	private ScoreRepository scoreRepository;

	public List<ScoreEntity> findAll() {
		return scoreRepository.findAll();

	}

}
