package com.desafioserasa.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PessoaDto {

	private Long id;
	@NotEmpty(message = "Nome não pode ser vazio.")
	@Size(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	private String nome;
	@NotEmpty(message = "Telefone não pode ser vazio.")
	@Size(min = 3, max = 14, message = "Telefone formato 99 99999-9999.")
	private String telefone;
	@Size(min = 1, max = 2, message = "Idade 99.")
	private Integer idade;
	private String cidade;
	@Size(min = 2, max = 2, message = "Unidade federativa XX.")
	private String estado;
	@Size(min = 1, max = 4, message = "Score de 0 a 1000.")
	private BigDecimal score;

	public PessoaDto(Long id, String nome, String telefone, Integer idade, String cidade, String estado,
			BigDecimal score) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.idade = idade;
		this.cidade = cidade;
		this.estado = estado;
		this.score = score;
	}

	public PessoaDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
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

	
	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "CadastroPessoaDto [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", idade=" + idade
				+ ", cidade=" + cidade + ", estado=" + estado + ", score=" + score + "]";
	}

}
