package br.com.vsouzaf.figurinhas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.vsouzaf.figurinhas.entity.FigurinhaAlbum;
import br.com.vsouzaf.figurinhas.repository.FigurinhaAlbumRepository;

@Service
public class FigurinhaAlbumService {
	
	@Autowired
	FigurinhaAlbumRepository figurinhaAlbumRepository;
	
	public List<FigurinhaAlbum> listar() {
        return figurinhaAlbumRepository.findAll();
    }
	
	public Page<FigurinhaAlbum> listarPaginado( int page, int count) {
        Pageable pages = new PageRequest(page, count);
        return figurinhaAlbumRepository.findAll(pages);
    }

    public FigurinhaAlbum salvar(FigurinhaAlbum figurinhaAlbum) {
        return figurinhaAlbumRepository.save(figurinhaAlbum);
    }

    public void deletar(String id) {
        figurinhaAlbumRepository.delete(id);
    }

    public FigurinhaAlbum getById(String id) {
        return figurinhaAlbumRepository.findOne(id);
    }
}
