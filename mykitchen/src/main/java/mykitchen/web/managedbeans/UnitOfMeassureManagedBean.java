package mykitchen.web.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mykitchen.business.UnitOfMeasureBean;
import mykitchen.model.UnitOfMeasure;

import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class UnitOfMeassureManagedBean implements Serializable {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;

	private List<UnitOfMeasure> uoms;

	private UnitOfMeasure selectedUOM;

	@EJB
	private UnitOfMeasureBean unitOfMeasureBean;

	@PostConstruct
	public void init() {
		loadUOM();
	}

	public UnitOfMeasure getSelectedUOM() {
		return selectedUOM;
	}

	public void setSelectedUOM(UnitOfMeasure selectedUOM) {
		this.selectedUOM = selectedUOM;
	}

	public List<UnitOfMeasure> getUoms() {
		return uoms;
	}

	public void setUoms(List<UnitOfMeasure> uoms) {
		this.uoms = uoms;
	}

	public void loadUOM() {
		uoms = unitOfMeasureBean.getAll();
	}

	public void addUOM() {
		selectedUOM = new UnitOfMeasure();

		RequestContext.getCurrentInstance().execute("uomDialog.show()");
	}

	public void editUOM() {
		RequestContext.getCurrentInstance().execute("uomDialog.show()");
	}

	public void deleteUOM() {
		uoms.remove(selectedUOM);
	}

	public void save() {
		unitOfMeasureBean.putUOM(selectedUOM);

		RequestContext.getCurrentInstance().execute("uomDialog.hide()");

		loadUOM();
	}
}