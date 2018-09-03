package br.com.vsouzaf.figurinhas.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.google.gson.Gson;

import br.com.vsouzaf.figurinhas.service.ServicoCrudAbstrata;
import br.com.vsouzaf.figurinhas.to.ToAbstata;

public abstract class ControllerCrudAbstrata<S extends ServicoCrudAbstrata, T extends ToAbstata, ID extends Serializable> {
	protected S servico;
	protected Class<T> classeTo;

	public ControllerCrudAbstrata(S service) {
		this.servico = service;
	}
	
	public ControllerCrudAbstrata(S service, Class<T> classeTo) {
		this.servico = service;
		this.classeTo = classeTo;
	}

	@RequestMapping(value = "/paginacao/{pagina}/{numeroDaPagina}", method = RequestMethod.GET)
	public List<T> listarPaginado(@PathVariable("pagina") int pagina, @PathVariable("numeroDaPagina") int numeroDaPagina,
			HttpServletResponse resp) throws ServletException, IOException {
		return servico.listarPaginado(pagina, numeroDaPagina);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> salvar(@RequestBody T json) {
		T created = (T) this.servico.salvar(json);

		Map<String, Object> m = Maps.newHashMap();
		m.put("sucesso", true);
		m.put("objeto", created);
		return m;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody T get(@PathVariable ID id) {
		return (T) this.servico.getPorId(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> deletar(@PathVariable ID id) {
		this.servico.deletarPorId(id);
		Map<String, Object> m = Maps.newHashMap();
		m.put("success", true);
		return m;
	}
}
