package br.com.vsouzaf.figurinhas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.vsouzaf.figurinhas.entity.FigurinhaAlbum;

public interface FigurinhaAlbumRepository extends MongoRepository<FigurinhaAlbum, String> {

}
