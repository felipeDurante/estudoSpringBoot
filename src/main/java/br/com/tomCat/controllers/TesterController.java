package br.com.tomCat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TesterController {

	@RequestMapping("/")
	public String ola() {
		return "index";
	}

	@RequestMapping("/listaconvidados")
	public String listaConvidados(Model model) {

		// Iterable<PdvEntity> convidados = pdvService.getThenPdv();
		// model.addAttribute("convidados", convidados);

		return "listaconvidados";
	}

	@RequestMapping("/cadastroProduto")
	public String redirectCadastroProduto(Model model) {

		return "cadatroProduto";
	}

}
