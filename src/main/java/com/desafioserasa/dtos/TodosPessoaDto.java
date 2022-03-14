package com.desafioserasa.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TodosPessoaDto {

	@NotEmpty(message = "Nome não pode ser vazio.")
	@Size(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	private String nome;
	@NotEmpty(message = "Telefone não pode ser vazio.")
	@Size(min = 3, max = 14, message = "Telefone formato 99 99999-9999.")
	private String cidade;
	@Size(min = 2, max = 2, message = "Unidade federativa XX.")
	private String estado;
	@Size(min = 1, max = 4, message = "Score de 0 a 1000.")
	private Integer score;

	public TodosPessoaDto(String nome, String cidade, String estado, @Size(min = 1, max = 4, message = "Score de 0 a 1000.") Integer score) {
		super();

		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.score = score;
	}

	public TodosPessoaDto() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer integer) {
		this.score = integer;
	}

	@Override
	public String toString() {
		return "CadastroPessoaDto [ " + "nome=" + nome + ", " + ", cidade=" + cidade + ", estado=" + estado + ", score="
				+ score + "]";
	}

}
