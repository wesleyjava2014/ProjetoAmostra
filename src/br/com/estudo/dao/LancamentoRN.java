package br.com.estudo.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.estudo.jpaUtil.Transactional;
import br.com.estudo.modelo.Lancamento;
import br.com.estudo.servico.NegocioException;

public class LancamentoRN implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private LancamentoDAO dao;

	@Transactional
	public void adicionar(Lancamento lancamento) throws NegocioException {
		if (lancamento.getDataPagamento() != null
				&& lancamento.getDataPagamento().after(new Date())) {
			throw new NegocioException(
					"Data de pagamento não pode ser uma data futura.");
		}
		this.dao.guardar(lancamento);
	}

	@Transactional
	public void excluir(Lancamento lancamento) throws NegocioException {
		lancamento = this.dao.porId(lancamento.getId());

		if (lancamento.getDataPagamento() != null) {
			throw new NegocioException(
					"Não é possível excluir um lançamento pago!");
		}

		this.dao.remover(lancamento);
	}

	public Lancamento porId(Long id) {
		return this.dao.porId(id);
	}

	public List<Lancamento> todosLancamentos() {
		return this.dao.todosLancamentos();
	}
}
