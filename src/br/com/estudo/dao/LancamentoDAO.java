package br.com.estudo.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class LancamentoDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public LancamentoDAO(EntityManager manager) {
		super();
		this.manager = manager;
	}

}
