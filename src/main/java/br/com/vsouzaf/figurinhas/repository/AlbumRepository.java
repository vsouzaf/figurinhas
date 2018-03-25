package br.com.vsouzaf.figurinhas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.vsouzaf.figurinhas.entity.Album;

public interface AlbumRepository extends MongoRepository<Album, String> {

    Album findByNome(String nome);

}
