package br.com.vsouzaf.figurinhas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vsouzaf.figurinhas.entity.Usuario;
import br.com.vsouzaf.figurinhas.service.UsuarioService;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<Usuario> listar() {
        return this.usuarioService.listar();
    }
    
    @RequestMapping(value = "/usuario/{page}/{count}", method = RequestMethod.GET)
    public Page<Usuario> listarPaginado(@PathVariable int page, @PathVariable int count) {
        return this.usuarioService.listarPaginado(page, count);
    }
    
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public Usuario getById(@PathVariable String id) {
        return this.usuarioService.getById(id);
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public Usuario salvar(@RequestBody Usuario usuario) {
        return this.usuarioService.salvar(usuario);
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.PUT)
    public Usuario editar(@RequestBody Usuario usuario) {
        return this.usuarioService.salvar(usuario);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable String id) {
        this.usuarioService.deletar(id);
    }
}
