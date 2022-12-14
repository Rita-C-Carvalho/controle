package br.com.carvalhoatelie.mvc.controle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.carvalhoatelie.mvc.controle.dto.RequisicaoNovoMaterial;
import br.com.carvalhoatelie.mvc.controle.model.Material;
import br.com.carvalhoatelie.mvc.controle.repository.MaterialRepository;

@Controller
@RequestMapping("material")
public class MaterialController {
	//código para salvar o material no banco de dados

	@Autowired
	private MaterialRepository materialRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoMaterial requisicao) {
		return "material/formulario";
	}
	
	//O @valid e BindingResult serve para validar as  informações do fomulário

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoMaterial requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			return "material/formulario";
		}

		Material material = requisicao.toMaterial();
		materialRepository.save(material);
		return"material/formulario";
	}
}
