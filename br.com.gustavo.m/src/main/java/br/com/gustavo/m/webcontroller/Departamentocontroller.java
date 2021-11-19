package br.com.gustavo.m.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gustavo.m.domain.Departamento;
import br.com.gustavo.m.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class Departamentocontroller {
	
	private DepartamentoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar() { 
		return "/departamento/cadastro";
	}
@GetMapping("/listar")
public String listar(ModelMap model){
	model.addAttribute("departamentos", service.buscarTodos());
	return"/departamento/lista";
}
@PostMapping("/salvar")
public String Salvar(Departamento departamento, RedirectAttributes attr){
	
	attr.addFlashAttribute("success", "departamento salvo com sucesso");
	service.salvar(departamento);
	return "redirect:/departamentos/cadastrar";
	
}

@GetMapping("/editar/{id}")
public String preEditar(@PathVariable("id")Long id,ModelMap model) {
	model.addAttribute("departamento", service.buscarPorId(id));
	return"/departamento/cadastro";
}
	@PostMapping("/editar")
	public String editar(Departamento departamento, RedirectAttributes attr) {
		attr.addFlashAttribute("success", "departamento alterado com sucesso");
		service.editar(departamento);
		
		return "redirect:/departamentos/cadastrar"; 
	}
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id")Long id,ModelMap model) {
		if(service.departamentoTemCargos(id)) {
			model.addAttribute("fail", "Departamento nao removido .Possui Cargo(s) vinculado(s)"); 
			
		}else {
			service.excluir(id);
			model.addAttribute("success", "Departamento excluido com sucesso");
		}
		return listar(model);
		}
	
	}
	



