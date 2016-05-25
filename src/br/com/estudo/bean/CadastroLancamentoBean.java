package br.com.estudo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.estudo.dao.LancamentoRN;
import br.com.estudo.dao.PessoaRN;
import br.com.estudo.enumerdor.TipoLancamento;
import br.com.estudo.modelo.Lancamento;
import br.com.estudo.modelo.Pessoa;
import br.com.estudo.servico.NegocioException;

@Named
@ViewScoped
public class CadastroLancamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Lancamento lancamento = new Lancamento();
	@Inject
	private LancamentoRN lancamentoRn;
	@Inject
	private PessoaRN pessoaRn;
	private List<Pessoa> todasPessoas;

	public void preprarCadastro() {
		this.todasPessoas = pessoaRn.todasPessoas();
		if (this.lancamento == null) {
			this.lancamento = new Lancamento();
		}
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.lancamentoRn.adicionar(lancamento);
			this.limpar();
			context.addMessage(null, new FacesMessage(
					"Lançamento salvo com sucesso!"));
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public List<Pessoa> getTodasPessoas() {
		return todasPessoas;
	}

	public void limpar() {
		this.lancamento = new Lancamento();
	}
}
