package br.com.carvalhoatelie.mvc.controle.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import br.com.carvalhoatelie.mvc.controle.model.Produto;
import br.com.carvalhoatelie.mvc.controle.model.StatusProduto;

public class RequisicaoNovoProduto {


	@NotBlank(message = "O campo nome do produto é obrigatório.")
	private String nome;
	private String descricao;
	private BigDecimal valor;

	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@NotBlank(message = "O campo quantidade é obrigatório.")
	private String quantidade;

	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
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

	public Produto toProduto() {

		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setQuantidade(quantidade);
		produto.setValor(valor);
		produto.setStatus(StatusProduto.PRONTOS);
		
		return produto;

	}



}
