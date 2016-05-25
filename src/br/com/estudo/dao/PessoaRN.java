package br.com.estudo.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.estudo.modelo.Pessoa;

public class PessoaRN implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaDao dao;
	
	public List<Pessoa> todasPessoas(){
		return dao.todasPessoas();
	}

}
