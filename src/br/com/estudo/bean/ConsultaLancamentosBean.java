package br.com.estudo.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estudo.dao.LancamentoDAO;
import br.com.estudo.dao.LancamentoRN;
import br.com.estudo.jpaUtil.JpaUtil;
import br.com.estudo.modelo.Lancamento;

@Named
@ViewScoped
public class ConsultaLancamentosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Lancamento> lancamentos;

	@Inject
	private LancamentoRN lancamentoRN;

	public void consultar() {
		this.lancamentos = lancamentoRN.todosLancamentos();
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

}
