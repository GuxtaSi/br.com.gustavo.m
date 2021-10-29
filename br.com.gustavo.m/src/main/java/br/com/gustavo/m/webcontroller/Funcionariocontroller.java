package br.com.gustavo.m.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/funcionarios")
@Controller
public class Funcionariocontroller {
	
		
		@GetMapping("cadastrar")
		public String cadastrar() {
			return "/funcionario/cadastro";
		}
	@GetMapping("/listar")
	public String listar() {
		return"/funcionario/lista";
	
	}
	}

