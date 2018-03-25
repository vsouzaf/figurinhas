package br.com.vsouzaf.figurinhas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.vsouzaf.figurinhas.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	Usuario findByEmail(String username);
}
