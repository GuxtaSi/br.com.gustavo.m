package br.com.gustavo.m.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gustavo.m.domain.Cargo;
import br.com.gustavo.m.domain.Departamento;
import br.com.gustavo.m.domain.Funcionario;
import br.com.gustavo.m.domain.UF;
import br.com.gustavo.m.service.CargoService;
import br.com.gustavo.m.service.DepartamentoService;
import br.com.gustavo.m.service.FuncionarioService;

@RequestMapping("/funcionarios")
@Controller
public class Funcionariocontroller {
	
	@Autowired
	private CargoService cargoService;
    @Autowired
    private FuncionarioService funcionarioService;
	
		
		@GetMapping("cadastrar")
		public String cadastrar(Funcionario funcionario) {
			return "/funcionario/cadastro";
		}
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarTodos());
		return"/funcionario/lista";
	}
	
	@PostMapping("/salvar")
	public String Salvar(Funcionario funcionario, RedirectAttributes attr){
		
		attr.addFlashAttribute("success", "funcionario cadastrado com sucesso.");
		funcionarioService.salvar(funcionario);
		return "redirect:/funcionarios/cadastrar";
		
	}
	@ModelAttribute("cargos")
	public List<Cargo> getCargos(){
		return cargoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs(){
		return UF.values();
	}
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id,ModelMap model) {
		model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
		return"/funcionario/cadastro";
	}
		@PostMapping("/editar")
		public String editar(Funcionario funcionario, RedirectAttributes attr) {
			attr.addFlashAttribute("success", "funcionario alterado com sucesso");
			funcionarioService.editar(funcionario);
			
			return "redirect:/funcionarios/cadastrar"; 
		}
		
		@GetMapping("/excluir/{id}")
		public String excluir(@PathVariable("id")Long id,RedirectAttributes attr) {
			
			funcionarioService.excluir(id);
			attr.addFlashAttribute("success", "funcionario excluido com sucesso");
			
			return "redirect:/funcionarios/listar"; 
			}
	}

