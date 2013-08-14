package mykitchen.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import mykitchen.web.utils.SelectItemsUtils;

public abstract  class SelectItemBaseConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return SelectItemsUtils.findValueByStringConversion(context, component,
				value, this);
	}

	public static boolean isEmpty(Object[] array) {

		return array == null || array.length == 0;

	}
}
