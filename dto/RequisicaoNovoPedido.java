package br.com.carvalhoatelie.mvc.controle.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import br.com.carvalhoatelie.mvc.controle.model.Pedido;
import br.com.carvalhoatelie.mvc.controle.model.StatusPedido;

public class RequisicaoNovoPedido {

	@NotBlank(message = "O campo nome do produto é obrigatório.")
	private String nome;
	private String descricao;
	
	
	private BigDecimal valor;
	
	
	private LocalDate dataDaEntrega;

	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}
	public void setDataDaEntrega(LocalDate dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
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

	public Pedido toPedido() {

		Pedido pedido = new Pedido();
		pedido.setNome(nome);
		pedido.setDescricao(descricao);
		pedido.setStatus(StatusPedido.PRONTOS);
		pedido.setDataDaEntrega(dataDaEntrega);
		pedido.setValor(valor);


		return pedido;

	}



}
