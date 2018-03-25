package br.com.vsouzaf.figurinhas.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Album {
	@Id
	private String id;
	
	private String nome;
	
	@DBRef
	private List<FigurinhaAlbum> figunhasDoAlbum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<FigurinhaAlbum> getFigunhasDoAlbum() {
		return figunhasDoAlbum;
	}

	public void setFigunhasDoAlbum(List<FigurinhaAlbum> figunhasDoAlbum) {
		this.figunhasDoAlbum = figunhasDoAlbum;
	}
}
