package br.com.vsouzaf.figurinhas.constant;

public enum AlbumCopaEnum {
	
	NOME_ALBUM("Copa 2018", 10);
	
	private String descricao;
	
	private Integer quantidade;

	AlbumCopaEnum(String descricao, Integer quantidade) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

	public String getDescricao() {
		return descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
}
