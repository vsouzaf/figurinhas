package br.com.vsouzaf.figurinhas.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.vsouzaf.figurinhas.to.ToAbstata;
import br.com.vsouzaf.figurinhas.to.UsuarioTo;

@Document
public class Usuario extends BeanAbstrata {

    @Id
    private String id;

    private String nome;

    private int idade;

    private String email;
    
    private String senha;

    public Usuario() {
    }

    public Usuario(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	@Override
	public ToAbstata converterParaTo() {
		UsuarioTo usuario = new UsuarioTo();
		usuario.setId(id);
		usuario.setEmail(email);
		usuario.setIdade(idade);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		
		return usuario;
	}
}
