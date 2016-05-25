package br.com.estudo.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estudo.modelo.Pessoa;

public class PessoaDao implements Serializable {
	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public PessoaDao(EntityManager manager) {
		super();
		this.manager = manager;
	}

	protected List<Pessoa> todasPessoas() {
		TypedQuery<Pessoa> query = manager.createQuery("from Pessoa",
				Pessoa.class);
		return query.getResultList();
	}

}
