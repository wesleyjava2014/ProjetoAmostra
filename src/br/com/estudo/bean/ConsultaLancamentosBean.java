package br.com.estudo.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estudo.jpaUtil.JpaUtil;
import br.com.estudo.modelo.Lancamento;

@Named
@ViewScoped
public class ConsultaLancamentosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Lancamento> lancamentos;

	public void consultar() {
		EntityManager manager = JpaUtil.getEntityManager();
		TypedQuery<Lancamento> query = manager.createQuery("from Lancamento",
				Lancamento.class);
		this.lancamentos = query.getResultList();
		manager.close();
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

}
