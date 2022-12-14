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

import br.com.carvalhoatelie.mvc.controle.model.Produto;
import br.com.carvalhoatelie.mvc.controle.model.StatusProduto;
import br.com.carvalhoatelie.mvc.controle.repository.ProdutoRepository;

@Controller
@RequestMapping("/produtoHome")
public class ProdutoHomeController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public String produtoHome(Model model) {

		List<Produto> produtos = produtoRepository.findAll();
		model.addAttribute("produtos", produtos);

		return "produtoHome";
	}
	
	@GetMapping("{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {

		List<Produto> produtos = produtoRepository.findByStatus(StatusProduto.valueOf(status.toUpperCase()));
		model.addAttribute("produtos", produtos);

		return "produtoHome";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/produtoHome";
	}


}
