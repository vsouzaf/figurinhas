package br.com.vsouzaf.figurinhas.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Maps;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

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
	
	@RequestMapping(value = "formulario", method= RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public String getFormulario() throws Exception {
		String nomeFormulario = this.classeTo.getSimpleName();
		Integer posicaoASerRemovida = nomeFormulario.indexOf("To");
		nomeFormulario = nomeFormulario.substring(0, posicaoASerRemovida);
		nomeFormulario = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, nomeFormulario);
		
		JsonParser jsonParser = new JsonParser();
		
		JsonObject jsonObject;
		try {
			String nomeArquivo = "formulario/" + nomeFormulario + ".json";
			String arquivo = this.getClass().getClassLoader().getResource(nomeArquivo).getFile();
			jsonObject = (JsonObject) jsonParser.parse(new FileReader(arquivo));
		} catch (JsonIOException e) {
			throw new Exception("Não foi possível ler o arquivo JSON");
		} catch (JsonSyntaxException e) {
			throw new Exception("Não foi possível ler o arquivo JSON");
		} catch (FileNotFoundException e) {
			throw new Exception("Arquivo não encontrado, verifique se o existe um arquivo com mesmo nome da Classe TO: " + nomeFormulario);
		}
		
		return jsonObject.toString();
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
