package br.edu.infnet.apphospedagem.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apphospedagem.client.IUsuarioClient;
import br.edu.infnet.apphospedagem.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioClient usuarioClient;

	public Collection<Usuario> obterLista() {

		return usuarioClient.obterLista();
	}

	public void incluir(Usuario usuario) {

		usuarioClient.incluir(usuario);
	}

	public void excluir(Integer id) {

		usuarioClient.excluir(id);
	}

	public Usuario validar(String email, String senha) {

		return usuarioClient.validar(email, senha);
	}
}
