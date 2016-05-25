package br.com.estudo.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.estudo.modelo.Pessoa;

public class PessoaRN implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaDao dao;

	public void adicionar(Pessoa pessoa) {
		this.dao.adicionar(pessoa);
	}

	public Pessoa porId(Long id) {
		return this.dao.porId(id);
	}

	public List<Pessoa> todasPessoas() {
		return this.dao.todasPessoas();
	}

}
