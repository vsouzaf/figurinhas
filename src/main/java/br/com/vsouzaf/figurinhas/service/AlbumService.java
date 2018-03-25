package br.com.vsouzaf.figurinhas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.vsouzaf.figurinhas.entity.Album;
import br.com.vsouzaf.figurinhas.repository.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	AlbumRepository albumRepository;
	
	public List<Album> listar() {
        return albumRepository.findAll();
    }
	
	public Page<Album> listarPaginado( int page, int count) {
        Pageable pages = new PageRequest(page, count);
        return albumRepository.findAll(pages);
    }

    public Album salvar(Album album) {
        return albumRepository.save(album);
    }

    public void deletar(String id) {
        albumRepository.delete(id);
    }

    public Album getById(String id) {
        return albumRepository.findOne(id);
    }
}
