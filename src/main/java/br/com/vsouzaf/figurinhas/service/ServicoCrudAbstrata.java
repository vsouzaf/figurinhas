package br.com.vsouzaf.figurinhas.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.google.common.collect.Lists;

import br.com.vsouzaf.figurinhas.entity.BeanAbstrata;
import br.com.vsouzaf.figurinhas.to.ToAbstata;

public abstract class ServicoCrudAbstrata<T extends ToAbstata, B extends BeanAbstrata, ID extends Serializable> {
	protected MongoRepository<B, ID> repositorio;
	
	public ServicoCrudAbstrata(MongoRepository<B, ID> repo) {
        this.repositorio = repo;
    }

	public List<T> listarPaginado(Integer pagina, Integer numRegistrosPorPagina) {
		Pageable pages = new PageRequest(pagina, numRegistrosPorPagina);
		Iterable<B> all = this.repositorio.findAll(pages);
		List<T> list = Lists.newArrayList();

		all.forEach(item -> list.add((T) item.converterParaTo()));

		return list;
	}

	@SuppressWarnings("unchecked")
	public T salvar(T entidade) {
		B bean = (B) entidade.converterParaBean();
		bean = this.repositorio.save(bean);
		return (T) bean.converterParaTo();
	}
	
	public T getPorId(ID id) {
		B bean = this.repositorio.findOne(id);
		T registro = null;
		
		if(bean != null) {
			registro = (T) bean.converterParaTo();
		}
		
		return registro;
	}
	
	public void deletarPorId(ID id) {
		this.repositorio.delete(id);
	}
}
