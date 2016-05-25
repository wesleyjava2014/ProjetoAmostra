package br.com.estudo.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estudo.dao.LancamentoDAO;
import br.com.estudo.dao.LancamentoRN;
import br.com.estudo.jpaUtil.JpaUtil;
import br.com.estudo.modelo.Lancamento;
import br.com.estudo.servico.NegocioException;

@Named
@ViewScoped
public class ConsultaLancamentosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Lancamento> lancamentos;
	private Lancamento lancamentoSelecionado;

	@Inject
	private LancamentoRN lancamentoRN;

	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			this.lancamentoRN.excluir(this.lancamentoSelecionado);
			this.consultar();

			context.addMessage(null, new FacesMessage(
					"Lançamento excluído con sucesso!"));
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public void consultar() {
		this.lancamentos = lancamentoRN.todosLancamentos();
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}

}
