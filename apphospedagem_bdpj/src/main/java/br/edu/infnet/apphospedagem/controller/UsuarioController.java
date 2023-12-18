package br.edu.infnet.apphospedagem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.apphospedagem.model.Usuario;
import br.edu.infnet.apphospedagem.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;

@SessionAttributes("username")
@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping(value = "/valida")
	public String validar(Model model, @RequestParam String email, @RequestParam String senha) {

		Usuario user = usuarioService.validar(email, senha);
		
		if(user != null) {
			
			model.addAttribute("user", user);

			return "home";
		}
		return "redirect:/login";		
	}	
	
	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {

		model.addAttribute("listaUsuario", usuarioService.obterLista());
		
		return "usuario/lista";
	}

	@GetMapping(value = "/usuario/cadastro")
	public String telaCadastro() {

		return "usuario/cadastro";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario) {

		usuarioService.incluir(usuario);
		
		return "redirect:/";
	}

	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		usuarioService.excluir(id);

		return "redirect:/usuario/lista";
	}
}
