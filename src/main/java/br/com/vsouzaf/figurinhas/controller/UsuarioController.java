package br.com.vsouzaf.figurinhas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vsouzaf.figurinhas.service.UsuarioService;
import br.com.vsouzaf.figurinhas.to.UsuarioTo;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends ControllerCrudAbstrata<UsuarioService, UsuarioTo, String>{
	
	@Autowired
	public UsuarioController(UsuarioService service) {
		super(service, UsuarioTo.class);
	}
}