package mykitchen.web.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mykitchen.business.RecipeBean;

@ManagedBean
@ViewScoped
public class GalleriaManagedBean implements Serializable {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;

	private List<String> imagesPath;

	@EJB
	private RecipeBean recipeBean;

	@PostConstruct
	public void init() {		
		imagesPath = recipeBean.getAllRecipeImages();
		System.out.println(imagesPath);
	}

	public List<String> getImagesPath() {
		return imagesPath;
	}

	public void setImagesPath(List<String> imagesPath) {
		this.imagesPath = imagesPath;
	}
}