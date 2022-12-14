//A anotação @Controller serve para conectar o Spring ao HTML.

package br.com.carvalhoatelie.mvc.controle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.carvalhoatelie.mvc.controle.model.Pedido;
import br.com.carvalhoatelie.mvc.controle.model.StatusPedido;
import br.com.carvalhoatelie.mvc.controle.repository.PedidoRepository;

@Controller
@RequestMapping("/pedidoHome")
public class PedidoHomeController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public String pedidoHome(Model model) {

		List<Pedido> pedidos = pedidoRepository.findAll();
		model.addAttribute("pedidos", pedidos);

		return "pedidoHome";
	}
	
	@GetMapping("{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {

		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);

		return "pedidoHome";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/pedidoHome";
	}
}
