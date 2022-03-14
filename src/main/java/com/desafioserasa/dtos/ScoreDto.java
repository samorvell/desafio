package com.desafioserasa.dtos;

public class ScoreDto {

	private String scoreDescricao;

	private Integer scoreFinal;

	private Integer scoreInicial;
	
	

	public ScoreDto(String scoreDescricao, Integer scoreFinal, Integer scoreInicial) {
		this.scoreDescricao = scoreDescricao;
		this.scoreFinal = scoreFinal;
		this.scoreInicial = scoreInicial;
	}

	public String getScoreDescricao() {
		return scoreDescricao;
	}

	public void setScoreDescricao(String scoreDescricao) {
		this.scoreDescricao = scoreDescricao;
	}

	public Integer getScoreFinal() {
		return scoreFinal;
	}

	public void setScoreFinal(Integer scoreFinal) {
		this.scoreFinal = scoreFinal;
	}

	public Integer getScoreInicial() {
		return scoreInicial;
	}

	public void setScoreInicial(Integer scoreInicial) {
		this.scoreInicial = scoreInicial;
	}

	@Override
	public String toString() {
		return "ScoreDto [scoreDescricao=" + scoreDescricao + ", scoreFinal=" + scoreFinal + ", scoreInicial="
				+ scoreInicial + "]";
	}
	
	

}
