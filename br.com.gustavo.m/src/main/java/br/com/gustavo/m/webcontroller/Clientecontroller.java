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

import br.com.gustavo.m.domain.Profissao;
import br.com.gustavo.m.domain.Empresa;
import br.com.gustavo.m.domain.Cliente;
import br.com.gustavo.m.domain.UF;
import br.com.gustavo.m.service.ProfissaoService;
import br.com.gustavo.m.service.EmpresaService;
import br.com.gustavo.m.service.ClienteService;

@SuppressWarnings("unused")
@RequestMapping("/clientes")
@Controller
public class Clientecontroller {
	
	@Autowired
	private ProfissaoService profissaoService;
    @Autowired
    private ClienteService clienteService;
	
		
		@GetMapping("cadastrar")
		public String cadastrar(Cliente cliente) {
			return "/cliente/cadastro";
		}
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("clientes", clienteService.buscarTodos());
		return"/cliente/lista";
	}
	
	@PostMapping("/salvar")
	public String Salvar(Cliente cliente, RedirectAttributes attr){
		
		attr.addFlashAttribute("success", "Cliente cadastrado com sucesso.");
		clienteService.salvar(cliente);
		return "redirect:/clientes/cadastrar";
		
	}
	@ModelAttribute("profissoes")
	public List<Profissao> getProfissao(){
		return profissaoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs(){
		return UF.values();
	}
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id,ModelMap model) {
		model.addAttribute("cliente", clienteService.buscarPorId(id));
		return"/cliente/cadastro";
	}
		@PostMapping("/editar")
		public String editar(Cliente cliente, RedirectAttributes attr) {
			attr.addFlashAttribute("success", "cliente alterado com sucesso");
			clienteService.editar(cliente);
			
			return "redirect:/clientes/cadastrar"; 
		}
		
		@GetMapping("/excluir/{id}")
		public String excluir(@PathVariable("id")Long id,RedirectAttributes attr) {
			
			clienteService.excluir(id);
			attr.addFlashAttribute("success", "cliente excluido com sucesso");
			
			return "redirect:/clientes/listar"; 
			}
	}

