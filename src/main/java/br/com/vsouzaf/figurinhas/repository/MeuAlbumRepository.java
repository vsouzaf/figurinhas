package br.com.vsouzaf.figurinhas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.vsouzaf.figurinhas.entity.MeuAlbum;

public interface MeuAlbumRepository extends MongoRepository<MeuAlbum, String> {
}
