package br.com.estudo.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.estudo.modelo.Lancamento;

public class LancamentoRN implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private LancamentoDAO dao;

	public List<Lancamento> todosLancamentos() {
		return dao.todosLancamentos();
	}
}
