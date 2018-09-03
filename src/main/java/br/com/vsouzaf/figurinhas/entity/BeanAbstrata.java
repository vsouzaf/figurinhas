package br.com.vsouzaf.figurinhas.entity;

import java.io.Serializable;

import br.com.vsouzaf.figurinhas.to.ToAbstata;


public abstract class BeanAbstrata implements Serializable {
	public abstract ToAbstata converterParaTo();
}
