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
import br.com.gustavo.m.service.CargoService;
import br.com.gustavo.m.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
        @Autowired
		private CargoService cargoService;
        @Autowired
        private DepartamentoService departamentoService;
        
        
		@GetMapping("cadastrar")
		public String cadastrar(Cargo cargo) {
			return "/cargo/cadastro";
		}
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos",cargoService.buscarTodos());
		return"/cargo/lista";
	}
	@PostMapping("/salvar")
	public String Salvar(Cargo cargo, RedirectAttributes attr){
		
		attr.addFlashAttribute("success", "Cargo inserido com sucesso");
		cargoService.salvar(cargo);
		return "redirect:/cargos/cadastrar";
		
	}
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamento(){
		return departamentoService.buscarTodos();
	}
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id,ModelMap model) {
		model.addAttribute("cargo", cargoService.buscarPorId(id));
		return"/cargos/cadastro";
	}
		@PostMapping("/editar")
		public String editar(Cargo cargo, RedirectAttributes attr) {
			attr.addFlashAttribute("success", "Cargo alterado com sucesso");
			cargoService.editar(cargo);
			
			return "redirect:/cargos/cadastrar"; 
		}
		
		@GetMapping("/excluir/{id}")
		public String excluir(@PathVariable("id")Long id,ModelMap model) {
			if(cargoService.cargoTemFuncionario(id)) {
				model.addAttribute("fail", "Cargo nao removido .Possui Cargo(s) vinculado(s)"); 
				
			}else {
				cargoService.excluir(id);
				model.addAttribute("success", "Cargo excluido com sucesso");
			}
			return listar(model);
			}
	}

