package mykitchen.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import mykitchen.model.Product;

public class ProductConverter extends SelectItemBaseConverter {

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return ((Product) value).getName();
	}

}
