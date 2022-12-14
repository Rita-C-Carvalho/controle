package br.com.carvalhoatelie.mvc.controle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.carvalhoatelie.mvc.controle.dto.RequisicaoNovoPedido;
import br.com.carvalhoatelie.mvc.controle.model.Pedido;
import br.com.carvalhoatelie.mvc.controle.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	//código para salvar o pedido no banco de dados

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}
	
	//O @valid e BindingResult serve para validar as  informações do fomulário

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			return "pedido/formulario";
		}

		Pedido pedido = requisicao.toPedido();
		pedidoRepository.save(pedido);
		return"redirect:/pedidoHome";
	}
}
