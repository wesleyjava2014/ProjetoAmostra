package br.com.estudo.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estudo.jpaUtil.JpaUtil;
import br.com.estudo.modelo.Lancamento;

public class LancamentoDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public LancamentoDAO(EntityManager manager) {
		super();
		this.manager = manager;
	}

	protected List<Lancamento> todosLancamentos() {
		TypedQuery<Lancamento> query = manager.createQuery("from Lancamento",
				Lancamento.class);
		return query.getResultList();
	}
}
