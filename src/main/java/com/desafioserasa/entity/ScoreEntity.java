package com.desafioserasa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "score")
public class ScoreEntity implements Serializable {

	private static final long serialVersionUID = -5754246207015712518L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String scoreDescricao;
	@Column(nullable = false)
	private Integer scoreFinal;
	@Column(nullable = false)
	private Integer scoreInicial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScoreDescricao() {
		return scoreDescricao;
	}

	public void setScoreDescricao(String scoreDescricao) {
		this.scoreDescricao = scoreDescricao;
	}

	public Integer getScoreInicial() {
		return scoreInicial;
	}

	public void setScoreInicial(Integer scoreInicial) {
		this.scoreInicial = scoreInicial;
	}

	public Integer getScoreFinal() {
		return scoreFinal;
	}

	public void setScoreFinal(Integer scoreFinal) {
		this.scoreFinal = scoreFinal;
	}

	@Override
	public String toString() {
		return "ScoreEntity [id=" + id + ", scoreDescricao=" + scoreDescricao + ", scoreInicial=" + scoreInicial
				+ ", scoreFinal=" + scoreFinal + "]";
	}

}
