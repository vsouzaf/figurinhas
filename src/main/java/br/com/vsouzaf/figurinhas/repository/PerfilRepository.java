package br.com.vsouzaf.figurinhas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.vsouzaf.figurinhas.entity.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String> {

    Perfil findByNome(String role_admin);

}
