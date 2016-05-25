package br.com.estudo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.estudo.dao.LancamentoRN;
import br.com.estudo.modelo.Lancamento;

@FacesConverter(forClass = Lancamento.class)
public class LancamentoConverter implements Converter {

	@Inject
	private LancamentoRN lancamentoRn;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		// TODO Auto-generated method stub
		Lancamento retorno = null;
		if (value != null && !"".equals(value)) {
			retorno = this.lancamentoRn.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		// TODO Auto-generated method stub
		if (value != null) {
			Lancamento lancamento = ((Lancamento) value);
			return lancamento.getId() == null ? null : lancamento.getId()
					.toString();
		}
		return null;
	}

}
