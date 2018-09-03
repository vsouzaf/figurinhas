package br.com.vsouzaf.figurinhas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;

import br.com.vsouzaf.figurinhas.service.UsuarioService;
import br.com.vsouzaf.figurinhas.to.UsuarioTo;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends ControllerCrudAbstrata<UsuarioService, UsuarioTo, String>{
	
	@Autowired
	public UsuarioController(UsuarioService service) {
		super(service, UsuarioTo.class);
	}
	
	@RequestMapping(value = "/salvar_multiplo", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> salvarMultiplosUsuarios(@RequestBody UsuarioTo json) {
		UsuarioTo created = this.servico.salvar(json);

		Map<String, Object> m = Maps.newHashMap();
		m.put("success", true);
		m.put("created", created);
		return m;
	}
}