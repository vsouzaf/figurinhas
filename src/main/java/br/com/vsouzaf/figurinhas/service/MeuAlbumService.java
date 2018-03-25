package br.com.vsouzaf.figurinhas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.vsouzaf.figurinhas.entity.MeuAlbum;
import br.com.vsouzaf.figurinhas.repository.MeuAlbumRepository;

@Service
public class MeuAlbumService {
	
	@Autowired
	MeuAlbumRepository meuAlbumRepository;
	
	public List<MeuAlbum> listar() {
        return meuAlbumRepository.findAll();
    }
	
	public Page<MeuAlbum> listarPaginado( int page, int count) {
        Pageable pages = new PageRequest(page, count);
        return meuAlbumRepository.findAll(pages);
    }

    public MeuAlbum salvar(MeuAlbum meuAlbum) {
        return meuAlbumRepository.save(meuAlbum);
    }

    public void deletar(String id) {
        meuAlbumRepository.delete(id);
    }

    public MeuAlbum getById(String id) {
        return meuAlbumRepository.findOne(id);
    }
}
