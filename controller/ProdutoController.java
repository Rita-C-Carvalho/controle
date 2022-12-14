package br.com.carvalhoatelie.mvc.controle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.carvalhoatelie.mvc.controle.dto.RequisicaoNovoProduto;
import br.com.carvalhoatelie.mvc.controle.model.Produto;
import br.com.carvalhoatelie.mvc.controle.repository.ProdutoRepository;

@Controller
@RequestMapping("produto")
public class ProdutoController {
	//código para salvar o produto no banco de dados

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoProduto requisicao) {
		return "produto/formulario";
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoProduto requisicao, BindingResult resultt) {
		
		if(resultt.hasErrors()) {
			return "produto/formulario";
		}

		Produto produto = requisicao.toProduto();
		produtoRepository.save(produto);
		return"redirect:/produtoHome";
	}
}
