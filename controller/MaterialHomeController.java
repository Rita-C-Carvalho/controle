//A anotação @Controller serve para conectar o Spring ao HTML.

package br.com.carvalhoatelie.mvc.controle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.carvalhoatelie.mvc.controle.model.Material;
import br.com.carvalhoatelie.mvc.controle.repository.MaterialRepository;

@Controller
public class MaterialHomeController {

	@Autowired
	private MaterialRepository materialRepository;

	@GetMapping("/materialHome")
	public String materialHome(Model model) {

		List<Material> materials = materialRepository.findAll();
		model.addAttribute("materials", materials);

		return "materialHome";
	}

}
