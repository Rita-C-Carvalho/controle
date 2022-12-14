package br.com.carvalhoatelie.mvc.controle.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import br.com.carvalhoatelie.mvc.controle.model.Material;

public class RequisicaoNovoMaterial {

	@NotBlank(message = "O campo nome do produto é obrigatório.")
	private String nome;
	private String descricao;
	
	
	private BigDecimal valor;
	
	@NotBlank(message = "O campo quantidade é obrigatório.")
	private String quantidade;

	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setquantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Material toMaterial() {

		Material material = new Material();
		material.setNome(nome);
		material.setDescricao(descricao);
		material.setQuantidade(quantidade);
		material.setValor(valor);


		return material;

	}



}
