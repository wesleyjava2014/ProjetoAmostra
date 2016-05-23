package br.com.estudo.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.estudo.modelo.Lancamento;

@Named
@ViewScoped
public class LancamentoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private List<Lancamento> lancamentos;
	
	public void consultar(){
		
	}

}
