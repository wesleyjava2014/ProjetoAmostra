package br.com.estudo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.estudo.dao.PessoaRN;
import br.com.estudo.modelo.Pessoa;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {

	@Inject
	private PessoaRN pessoaRn;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if (value != null && !"".equals(value)) {
			return pessoaRn.porId(new Long(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		// TODO Auto-generated method stub
		if (value != null) {
			return ((Pessoa) value).getId().toString();
		}
		return null;
	}

}
