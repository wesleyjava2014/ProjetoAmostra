package br.com.estudo.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.estudo.dao.PessoaRN;
import br.com.estudo.modelo.Pessoa;

@Named
@ViewScoped
public class ConsultaPessoaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Pessoa> pessoas;

	@Inject
	private PessoaRN pessoaRn;

	public void consultarPessoa() {
		this.pessoas = pessoaRn.todasPessoas();
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

}
