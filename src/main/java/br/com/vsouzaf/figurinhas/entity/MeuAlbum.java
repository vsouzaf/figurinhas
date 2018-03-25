package br.com.vsouzaf.figurinhas.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MeuAlbum {
	@Id
	private String id;
	
	@DBRef
	private Album album;
	
	@DBRef
	private List<FigurinhaAlbum> figurinhasDoMeuAlbum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public List<FigurinhaAlbum> getFigurinhasDoMeuAlbum() {
		return figurinhasDoMeuAlbum;
	}

	public void setFigurinhasDoMeuAlbum(List<FigurinhaAlbum> figurinhasDoMeuAlbum) {
		this.figurinhasDoMeuAlbum = figurinhasDoMeuAlbum;
	}
}
