package br.com.gustavo.m.webcontroller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class homecontroller {
	
	@GetMapping("/")
	public String home() {
		return "/home";
	}

}
