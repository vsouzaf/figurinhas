package br.com.vsouzaf.figurinhas.service;

import org.springframework.stereotype.Service;

import br.com.vsouzaf.figurinhas.entity.Usuario;
import br.com.vsouzaf.figurinhas.repository.UsuarioRepository;
import br.com.vsouzaf.figurinhas.to.UsuarioTo;

@Service
public class UsuarioService extends ServicoCrudAbstrata<UsuarioTo, Usuario, String>{

	public UsuarioService(UsuarioRepository repo) {
		super(repo);
	}
}
