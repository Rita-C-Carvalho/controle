//A anotação @Controller serve para conectar o Spring ao HTML.

package br.com.carvalhoatelie.mvc.controle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}

}
