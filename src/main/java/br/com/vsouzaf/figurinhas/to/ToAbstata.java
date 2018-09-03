package br.com.vsouzaf.figurinhas.to;

import java.io.Serializable;

import br.com.vsouzaf.figurinhas.entity.BeanAbstrata;

public abstract class ToAbstata implements Serializable {
	public abstract BeanAbstrata converterParaBean();
}
