package br.com.vsouzaf.figurinhas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.vsouzaf.figurinhas.entity.Usuario;
import br.com.vsouzaf.figurinhas.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
	
	public Page<Usuario> listarPaginado( int page, int count) {
        Pageable pages = new PageRequest(page, count);
        return usuarioRepository.findAll(pages);
    }

    public Usuario salvar(Usuario usuarioAdd) {
        return usuarioRepository.save(usuarioAdd);
    }

    public void deletar(String id) {
        usuarioRepository.delete(id);
    }

    public Usuario getById(String id) {
        return usuarioRepository.findOne(id);
    }
}
